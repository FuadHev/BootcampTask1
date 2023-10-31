package com.fuadhev.mybootcamp.ui.safety

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fuadhev.mybootcamp.R
import com.fuadhev.mybootcamp.common.base.BaseFragment
import com.fuadhev.mybootcamp.databinding.FragmentSafetyBinding


class SafetyFragment : BaseFragment<FragmentSafetyBinding>(FragmentSafetyBinding::inflate) {


    override fun observeEvents() {

    }

    override fun onCreateFinish() {
        binding.webview.settings.javaScriptEnabled=true
        binding.webview.loadUrl("https://www.google.com/?hl=tr")

    }




}