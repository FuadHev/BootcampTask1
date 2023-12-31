package com.fuadhev.mybootcamp.ui.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fuadhev.mybootcamp.common.GenericDiffUtil
import com.fuadhev.mybootcamp.databinding.HomeRvItemBinding
import com.fuadhev.mybootcamp.databinding.NewsItemBinding
import com.fuadhev.mybootcamp.model.HomeItem
import com.fuadhev.mybootcamp.model.NewsUiModel

private val diffUtil = GenericDiffUtil<NewsUiModel>(
    myItemsTheSame = { oldItem, newItem -> oldItem.id == newItem.id },
    myContentsTheSame = { oldItem, newItem -> oldItem == newItem }
)
class NewsAdapter : ListAdapter<NewsUiModel,NewsAdapter.NewsViewHolder>(diffUtil) {

    inner class NewsViewHolder(val binding: NewsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: NewsUiModel,context: Context){

            with(binding){
                val resourceId = context.resources.getIdentifier(item.newsImg, "drawable", context.packageName)
                Glide.with(context) // this, mevcut Activity veya Fragment'ı temsil eder.
                    .load(resourceId)
                    .into(newsImg)

                newsTxt.text=item.newsTxt
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = NewsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(view)
    }

//    override fun getItemCount(): Int {
//        return
//    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(getItem(position),holder.itemView.context)
    }

//    object NewsDiffUtilCallback : DiffUtil.ItemCallback<NewsUiModel>() {
//        override fun areItemsTheSame(oldItem: NewsUiModel, newItem: NewsUiModel): Boolean {
//            return oldItem.id == newItem.id
//        }
//        override fun areContentsTheSame(
//            oldItem: NewsUiModel,
//            newItem: NewsUiModel,
//        ): Boolean {
//            return oldItem == newItem
//        }
//    }



//    val differ = AsyncListDiffer(this, diffUtil)
}