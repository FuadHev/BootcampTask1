package com.fuadhev.mybootcamp.ui.quickquestions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fuadhev.mybootcamp.R
import com.fuadhev.mybootcamp.common.base.BaseFragment
import com.fuadhev.mybootcamp.databinding.FragmentQuickQuestionsBinding
import com.fuadhev.mybootcamp.model.QuestionUiModel
import com.fuadhev.mybootcamp.ui.quickquestions.adapter.QuestionAdapter


class QuickQuestionsFragment : BaseFragment<FragmentQuickQuestionsBinding>(FragmentQuickQuestionsBinding::inflate) {


    private val questionAdapter by lazy {
        QuestionAdapter()
    }

    override fun observeEvents() {

    }

    override fun onCreateFinish() {

        setAdapter()

    }

    override fun setupListeners() {

    }


    fun setAdapter(){

        questionAdapter.differ.submitList(arrayListOf(QuestionUiModel(1,"Elektrik Təchizatı şəbəkəsinə qoşulmaq üçün onlayn müraciət edə bilərəm?"),
            QuestionUiModel(2,"Elektrik Təchizatı şəbəkəsinə qoşulmaq üçün qoşulma haqqını onlayn ödəyə bilərəm?"),
            QuestionUiModel(3,"Elektrik Təchizatı şəbəkəsinə qoşulmaq üçün hara müraciət edə bilərəm?"),
            QuestionUiModel(4,"Texniki şərt almaq üçün hansı sənədlər tələb olunur?"),
            QuestionUiModel(5,"Elektrik Təchizatı şəbəkəsinə qoşulmaq üçün nə qədər vəsait ödəməliyəm?"),
            QuestionUiModel(6,"Texniki şərtim var güc artırmaq istəyirəm, nə etməliyəm?"),
            QuestionUiModel(7,"Enerji təchizatı müəssisəsi müraciətin icrasından imtina edə bilərmi?"),
            QuestionUiModel(8,"Tikinti-quraşdırma işlərinin aparılması üçün ETM-ə qoşulma haqqından başqa əlavə vəsait ödənilirmi?")
            ))

        binding.questionsRv.adapter=questionAdapter
    }

}