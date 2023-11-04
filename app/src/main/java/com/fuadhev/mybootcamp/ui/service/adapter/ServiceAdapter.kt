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
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.palette.graphics.Palette
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fuadhev.mybootcamp.R
import com.fuadhev.mybootcamp.common.GenericDiffUtil
import com.fuadhev.mybootcamp.databinding.ItemServiceBinding
import com.fuadhev.mybootcamp.model.HistoryUiModel
import com.fuadhev.mybootcamp.model.ServicesUiModel
import com.fuadhev.mybootcamp.ui.payment.adapter.HistoryAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ServiceAdapter : ListAdapter<ServicesUiModel, ServiceAdapter.ServiceViewHolder>(diffUtil) {
    inner class ServiceViewHolder(val binding: ItemServiceBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ServicesUiModel, context: Context) {

            with(binding) {
                val resourceId =
                    context.resources.getIdentifier(item.img, "drawable", context.packageName)
                Glide.with(context)
                    .load(resourceId)
                    .into(img)
                txt.text = item.txt
                setBgColor(binding.bg, context, resourceId)
            }
        }

    }

    fun setBgColor(bg: CardView, context: Context, resourceId: Int) {
        val dominantColor = ContextCompat.getColor(context, R.color.red)
        val bitmap = ContextCompat.getDrawable(context, resourceId)!!.toBitmap()
        val color = Palette.from(bitmap).generate().getDominantColor(dominantColor)
        bg.setCardBackgroundColor(color)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder {
        val view = ItemServiceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ServiceViewHolder(view)
    }

    override fun onBindViewHolder(holder: ServiceViewHolder, position: Int) {
        holder.bind(getItem(position), holder.itemView.context)

    }
}

private val diffUtil = GenericDiffUtil<ServicesUiModel>(
    myItemsTheSame = { oldItem, newItem -> oldItem.id == newItem.id },
    myContentsTheSame = { oldItem, newItem -> oldItem == newItem }
)