package com.fuadhev.mybootcamp.ui.quickquestions.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fuadhev.mybootcamp.databinding.HomeRvItemBinding
import com.fuadhev.mybootcamp.databinding.ItemQuestionBinding
import com.fuadhev.mybootcamp.model.HomeItem
import com.fuadhev.mybootcamp.model.QuestionUiModel

class QuestionAdapter: RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder>() {

    inner class QuestionViewHolder(val binding: ItemQuestionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: QuestionUiModel, context: Context){

            with(binding){
                questionTxt.text=item.questionTxt
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val view = ItemQuestionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return QuestionViewHolder(view)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        holder.bind(differ.currentList[position],holder.itemView.context)
    }

    object QuestionDiffUtilCallback : DiffUtil.ItemCallback<QuestionUiModel>() {
        override fun areItemsTheSame(oldItem: QuestionUiModel, newItem: QuestionUiModel): Boolean {
            return oldItem.id == newItem.id
        }
        override fun areContentsTheSame(
            oldItem: QuestionUiModel,
            newItem: QuestionUiModel,
        ): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, QuestionDiffUtilCallback)
}