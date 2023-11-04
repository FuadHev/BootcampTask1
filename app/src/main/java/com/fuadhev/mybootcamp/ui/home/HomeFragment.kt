package com.fuadhev.mybootcamp.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fuadhev.mybootcamp.R
import com.fuadhev.mybootcamp.common.base.BaseFragment
import com.fuadhev.mybootcamp.databinding.FragmentHomeBinding
import com.fuadhev.mybootcamp.model.HomeItem
import com.fuadhev.mybootcamp.model.NewsUiModel
import com.fuadhev.mybootcamp.ui.home.adapter.HomeAdapter
import com.fuadhev.mybootcamp.ui.home.adapter.NewsAdapter


class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private val homeAdapter by lazy {
        HomeAdapter()
    }
    private val newsAdapter by lazy {
        NewsAdapter()
    }
    override fun observeEvents() {

    }
    override fun onCreateFinish() {
        setAdapters()
    }
    private fun setAdapters(){
        homeAdapter.submitList(arrayListOf(HomeItem(1,"Ortalama enerji\nİstehlakı ","ortalama","#294D8C"),
            HomeItem(2," Add auto\nTop-Up","add_auto","#A8C5B7"),
            HomeItem(3,"Enerjiyə qənaət\nməsləhətləri","enerji","#EA5455")))

        newsAdapter.submitList(arrayListOf(NewsUiModel(1,"Prezident İlham Əliyev Mingəçevir şəhərinin elektrik paylayıcı şəbəkəsinin Avtomatik İdarəetmə...","xb2"),
            NewsUiModel(2,"Ağcabədinin Pərioğullar və Hacıbədəlli kəndlərinin elektrik şəbəkəsi yenidən qurulur.","xb1")
        ))

        binding.homeRv.adapter=homeAdapter
        binding.newsRv.adapter=newsAdapter
    }

}