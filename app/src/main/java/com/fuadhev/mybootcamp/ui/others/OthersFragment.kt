package com.fuadhev.mybootcamp.ui.others

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.fuadhev.mybootcamp.R
import com.fuadhev.mybootcamp.common.base.BaseFragment
import com.fuadhev.mybootcamp.databinding.FragmentOthersBinding


class OthersFragment : BaseFragment<FragmentOthersBinding>(FragmentOthersBinding::inflate) {

    override fun observeEvents() {
    }

    override fun onCreateFinish() {
    }

    override fun setupListeners() {
        with(binding) {
            btnQuestion.setOnClickListener {
                findNavController().navigate(OthersFragmentDirections.actionOthersFragmentToQuickQuestionsFragment())
            }
            btnTehluke.setOnClickListener {
                findNavController().navigate(OthersFragmentDirections.actionOthersFragmentToSafetyFragment())
            }
        }

    }

}