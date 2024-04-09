package com.example.firebaseapp.home.delegate

import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firebaseapp.base.BaseDelegate
import com.example.firebaseapp.home.HomeFragment
import com.example.firebaseapp.home.HomeViewModel
import com.example.firebaseapp.home.adapter.BrandAdapter
import com.example.firebaseapp.home.adapter.RecommendationAdapter

class HomeRecommendDelegate(f: HomeFragment, vm: HomeViewModel) :
    BaseDelegate<HomeFragment, HomeViewModel>(f,vm) {

    override fun onCreateView() {
        initRecommendations()
    }

    private fun initRecommendations() {
        mFragment.mBinding?.progressBar3?.visibility = View.VISIBLE
        mViewModel.recommendations.observe(mFragment.viewLifecycleOwner, Observer {
            mViewModel.recommendationList.setData(it)
            Log.i("HOANG", "initRecommendation: ${mViewModel.recommendationList.getSize()}")
            mFragment.mBinding?.recyclerRecommend?.layoutManager = GridLayoutManager(mActivity, 2)
            mFragment.mBinding?.recyclerRecommend?.adapter = RecommendationAdapter()
            mFragment.mBinding?.progressBar3?.visibility = View.GONE
        })
        mViewModel.loadRecommendation()
    }
}