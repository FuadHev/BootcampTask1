package com.fuadhev.mybootcamp.ui.autotopup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.fuadhev.mybootcamp.R
import com.fuadhev.mybootcamp.common.base.BaseFragment
import com.fuadhev.mybootcamp.databinding.FragmentAutoTopUpBinding


class AutoTopUpFragment : BaseFragment<FragmentAutoTopUpBinding>(FragmentAutoTopUpBinding::inflate) {

    override fun observeEvents() {
    }
    override fun onCreateFinish() {
    }
    override fun setupListeners() {
        binding.btnClose.setOnClickListener{
            findNavController().popBackStack()
        }

    }
}