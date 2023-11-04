package com.fuadhev.mybootcamp.ui.quickquestions.adapter

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
import com.fuadhev.mybootcamp.databinding.ItemQuestionBinding
import com.fuadhev.mybootcamp.model.HistoryUiModel
import com.fuadhev.mybootcamp.model.HomeItem
import com.fuadhev.mybootcamp.model.QuestionUiModel

class QuestionAdapter : ListAdapter<QuestionUiModel, QuestionAdapter.QuestionViewHolder>(diffUtil) {
    inner class QuestionViewHolder(val binding: ItemQuestionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: QuestionUiModel, context: Context) {
            with(binding) {
                questionTxt.text = item.questionTxt
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val view = ItemQuestionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return QuestionViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        holder.bind(getItem(position), holder.itemView.context)
    }

}

private val diffUtil = GenericDiffUtil<QuestionUiModel>(
    myItemsTheSame = { oldItem, newItem -> oldItem.id == newItem.id },
    myContentsTheSame = { oldItem, newItem -> oldItem == newItem }
)