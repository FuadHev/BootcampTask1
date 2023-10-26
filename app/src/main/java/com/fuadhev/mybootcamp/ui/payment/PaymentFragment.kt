package com.fuadhev.mybootcamp.ui.payment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fuadhev.mybootcamp.R
import com.fuadhev.mybootcamp.common.base.BaseFragment
import com.fuadhev.mybootcamp.databinding.FragmentPaymentBinding
import com.fuadhev.mybootcamp.model.HistoryUiModel
import com.fuadhev.mybootcamp.ui.payment.adapter.HistoryAdapter


class PaymentFragment : BaseFragment<FragmentPaymentBinding>(FragmentPaymentBinding::inflate) {


    private val historyAdapter by lazy {
        HistoryAdapter()
    }
    override fun observeEvents() {

    }

    override fun onCreateFinish() {
        setAdapter()

    }

    override fun setupListeners() {


    }
    private fun setAdapter(){

        historyAdapter.differ.submitList(arrayListOf(
            HistoryUiModel(1,"11.55","30632 KW/s","165 kW/s","06.03.2023"),
            HistoryUiModel(2,"19.18","30467 KW/s","274 kW/s","03.02.2023"),
            HistoryUiModel(3,"30.02","30193 KW/s","382 kW/s","05.01.2023")
        ))


        binding.historyRv.adapter=historyAdapter

    }

}