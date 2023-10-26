package com.fuadhev.mybootcamp.ui.home.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fuadhev.mybootcamp.databinding.HomeRvItemBinding
import com.fuadhev.mybootcamp.model.HomeItem

class HomeAdapter: RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    inner class HomeViewHolder(val binding: HomeRvItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(item: HomeItem,context:Context){

                with(binding){
                    val resourceId = context.resources.getIdentifier(item.img, "drawable", context.packageName)
                    Glide.with(context) // this, mevcut Activity veya Fragment'ı temsil eder.
                        .load(resourceId)
                        .into(icon)
                    homeItem.setCardBackgroundColor(Color.parseColor(item.colorCode))
                    txt.text=item.txt
                }

                }

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view = HomeRvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(view)
    }

    override fun getItemCount(): Int {
       return differ.currentList.size
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(differ.currentList[position],holder.itemView.context)
    }

    object HomeDiffUtilCallback : DiffUtil.ItemCallback<HomeItem>() {
        override fun areItemsTheSame(oldItem: HomeItem, newItem: HomeItem): Boolean {
            return oldItem.id == newItem.id
        }
        override fun areContentsTheSame(
            oldItem: HomeItem,
            newItem: HomeItem,
        ): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, HomeDiffUtilCallback)
}