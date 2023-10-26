package com.fuadhev.mybootcamp.ui.service.adapter

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.VectorDrawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.palette.graphics.Palette
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fuadhev.mybootcamp.databinding.ItemServiceBinding
import com.fuadhev.mybootcamp.model.ServicesUiModel

class ServiceAdapter: RecyclerView.Adapter<ServiceAdapter.ServiceViewHolder>() {

    inner class ServiceViewHolder(val binding: ItemServiceBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ServicesUiModel, context: Context){

            with(binding){
                val resourceId = context.resources.getIdentifier(item.img, "drawable", context.packageName)
                Glide.with(context) // this, mevcut Activity veya Fragment'ı temsil eder.
                    .load(resourceId)
                    .into(img)

                txt.text=item.txt



            }

        }
        fun setBgColor(img:ImageView,bg:View){
            val bitmap: Bitmap? = when (val drawable = img.drawable) {
                is VectorDrawable -> {
                    Bitmap.createBitmap(
                        drawable.intrinsicWidth,
                        drawable.intrinsicHeight,
                        Bitmap.Config.ARGB_8888
                    ).also {
                        val canvas = Canvas(it)
                        drawable.setBounds(0, 0, canvas.width, canvas.height)
                        drawable.draw(canvas)
                    }
                }
                is BitmapDrawable -> drawable.bitmap
                else -> null
            }
            val palette = bitmap?.let { Palette.from(it).generate() }
            val dominantColor = palette?.dominantSwatch?.rgb

            dominantColor?.let { color ->
                Log.e("color", "bind: $color")
                bg.setBackgroundColor(color)
            }

        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder {
        val view = ItemServiceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ServiceViewHolder(view)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: ServiceViewHolder, position: Int) {
        holder.bind(differ.currentList[position],holder.itemView.context)
        holder.setBgColor(holder.binding.img,holder.binding.bg)
    }

    object ServiceDiffUtilCallback : DiffUtil.ItemCallback<ServicesUiModel>() {
        override fun areItemsTheSame(oldItem: ServicesUiModel, newItem: ServicesUiModel): Boolean {
            return oldItem.id == newItem.id
        }
        override fun areContentsTheSame(
            oldItem: ServicesUiModel,
            newItem: ServicesUiModel,
        ): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, ServiceDiffUtilCallback)
}