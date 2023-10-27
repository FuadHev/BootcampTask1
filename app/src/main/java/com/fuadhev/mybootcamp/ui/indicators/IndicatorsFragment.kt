package com.fuadhev.mybootcamp.ui.indicators

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.fuadhev.mybootcamp.R
import com.fuadhev.mybootcamp.common.base.BaseFragment
import com.fuadhev.mybootcamp.databinding.FragmentIndicatorsBinding
import com.fuadhev.mybootcamp.ui.indicators.viewpagers.monthly.MonthlyFragment
import com.fuadhev.mybootcamp.ui.indicators.viewpagers.yearly.YearlyFragment
import com.google.android.material.tabs.TabLayoutMediator
import java.time.Year

class IndicatorsFragment : BaseFragment<FragmentIndicatorsBinding>(FragmentIndicatorsBinding::inflate) {

    private val fragmentList = ArrayList<Fragment>()
    private val fragmentTitleList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fragmentList.add(YearlyFragment())
        fragmentList.add(MonthlyFragment())



        fragmentTitleList.add("Yearly")
        fragmentTitleList.add("Monthly")


    }

    inner class MyViewPagerAdapter(fragmentActivity: FragmentActivity) :
        FragmentStateAdapter(fragmentActivity) {
        override fun getItemCount(): Int {
            return fragmentList.size
        }

        override fun createFragment(position: Int): Fragment {
            return fragmentList[position]
        }

    }
    private fun setTabLayoutManager() {
        val adapter = MyViewPagerAdapter(requireActivity())
        binding.viewpager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewpager) { tab, position ->
                tab.text = fragmentTitleList[position]

        }.attach()
//
    }
    override fun observeEvents() {


    }

    override fun onCreateFinish() {
        setTabLayoutManager()

    }

    override fun setupListeners() {


    }

}