package com.example.firebaseapp.home.delegate

import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.example.firebaseapp.base.BaseDelegate
import com.example.firebaseapp.home.HomeFragment
import com.example.firebaseapp.home.HomeViewModel
import com.example.firebaseapp.home.adapter.BannerListAdapter

class HomeBannerDelegate(f: HomeFragment, vm: HomeViewModel) :
    BaseDelegate<HomeFragment, HomeViewModel>(f,vm) {

    private val progressBar = mFragment.mBinding?.progressBanner

    override fun onViewCreated() {
        initBanner()
        banners()
    }

    private fun initBanner() {
        progressBar?.visibility = View.VISIBLE
        mViewModel.banners.observe(mFragment.viewLifecycleOwner, Observer {
            mViewModel.bannerList.setData(it)
            mFragment.mBinding?.progressBanner?.visibility = View.GONE
        })
        mViewModel.loadBanner()
    }

    private fun banners() {
        mFragment.mBinding?.viewpagerSlider?.adapter =
            BannerListAdapter(mFragment.mBinding!!.viewpagerSlider).apply {
                setData(mViewModel.bannerList)
            }
        mFragment.mBinding?.viewpagerSlider?.clipToPadding = false
        mFragment.mBinding?.viewpagerSlider?.clipChildren = false
        mFragment.mBinding?.viewpagerSlider?.offscreenPageLimit = 3
        mFragment.mBinding?.viewpagerSlider?.getChildAt(0)?.overScrollMode =
            RecyclerView.OVER_SCROLL_NEVER

        val compositePageTransformer = CompositePageTransformer().apply {
            addTransformer(MarginPageTransformer(40))
        }
        mFragment.mBinding?.viewpagerSlider?.setPageTransformer(compositePageTransformer)

        mFragment.mBinding?.dotIndicator?.visibility = View.VISIBLE
        mFragment.mBinding?.dotIndicator?.attachTo(mFragment.mBinding!!.viewpagerSlider)
    }
}