package com.example.firebaseapp.home.delegate

import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.firebaseapp.base.BaseDelegate
import com.example.firebaseapp.base.baseRV.BaseRecyclerListener
import com.example.firebaseapp.home.HomeFragment
import com.example.firebaseapp.home.HomeFragmentDirections
import com.example.firebaseapp.home.HomeViewModel
import com.example.firebaseapp.home.adapter.RecommendationAdapter
import com.example.firebaseapp.module.ItemModel

class HomeRecommendDelegate(f: HomeFragment, vm: HomeViewModel) :
    BaseDelegate<HomeFragment, HomeViewModel>(f,vm),BaseRecyclerListener<ItemModel> {

    override fun onViewCreated() {
        initRecommendations()
    }

    private fun initRecommendations() {
        mFragment.mBinding?.progressBar3?.visibility = View.VISIBLE
        mViewModel.recommendations.observe(mFragment.viewLifecycleOwner, Observer {
            mViewModel.recommendationList.setData(it)
            mFragment.mBinding?.recyclerRecommend?.layoutManager = GridLayoutManager(mActivity, 2)
            mFragment.mBinding?.recyclerRecommend?.adapter = RecommendationAdapter().apply {
                setData(mViewModel.recommendationList)
                setListener(this@HomeRecommendDelegate)
            }
            mFragment.mBinding?.progressBar3?.visibility = View.GONE
        })
        mViewModel.loadRecommendation()
    }

    override fun itemClick(position: Int, item: ItemModel) {
        val action = HomeFragmentDirections.actionHomeFragmentToBuyFragment(item)
        mFragment.findNavController().navigate(action)
    }
}