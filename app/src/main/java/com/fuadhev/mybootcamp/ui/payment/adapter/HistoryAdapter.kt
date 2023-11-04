package com.fuadhev.mybootcamp.ui.payment.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fuadhev.mybootcamp.common.GenericDiffUtil
import com.fuadhev.mybootcamp.databinding.HomeRvItemBinding
import com.fuadhev.mybootcamp.databinding.ItemHistoryBinding
import com.fuadhev.mybootcamp.model.HistoryUiModel
import com.fuadhev.mybootcamp.model.HomeItem
import com.fuadhev.mybootcamp.model.NewsUiModel
import com.fuadhev.mybootcamp.ui.home.adapter.HomeAdapter

class HistoryAdapter : ListAdapter<HistoryUiModel, HistoryAdapter.HistoryViewHolder>(diffUtil) {

    inner class HistoryViewHolder(val binding: ItemHistoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: HistoryUiModel, context: Context) {
            with(binding) {
                money.text = "${item.money} Azn"
                time.text = item.time
                totalKw.text = item.totalKw
                usedKW.text = item.usedKw
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val view = ItemHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HistoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.bind(getItem(position), holder.itemView.context)
    }

}

private val diffUtil = GenericDiffUtil<HistoryUiModel>(
    myItemsTheSame = { oldItem, newItem -> oldItem.id == newItem.id },
    myContentsTheSame = { oldItem, newItem -> oldItem == newItem }
)
