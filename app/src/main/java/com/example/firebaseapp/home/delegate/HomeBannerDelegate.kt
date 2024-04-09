package com.example.firebaseapp.home.delegate

import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.example.firebaseapp.base.BaseDelegate
import com.example.firebaseapp.home.HomeFragment
import com.example.firebaseapp.home.HomeViewModel
import com.example.firebaseapp.home.adapter.BannerListAdapter
import com.example.firebaseapp.module.SliderModel

class HomeBannerDelegate(f: HomeFragment, vm: HomeViewModel) :
    BaseDelegate<HomeFragment, HomeViewModel>(f,vm) {

    private val progressBar = mFragment.mBinding?.progressBanner
    val listUrl = listOf<SliderModel>(SliderModel("https://firebasestorage.googleapis.com/v0/b/project176-4aeec.appspot.com/o/banner1.png?alt=media&token=16fdd871-27bf-408d-be96-766e2a5944be"),
        SliderModel("https://firebasestorage.googleapis.com/v0/b/project175-f1c13.appspot.com/o/banner2.png?alt=media&token=2c2a98de-2240-4130-8a89-7fbe7e49fa21")
    )

    override fun onViewCreated() {
        initBanner()
        banners()
    }

    private fun initBanner() {
        progressBar?.visibility = View.VISIBLE
        mViewModel.banners.observe(mFragment.viewLifecycleOwner, Observer {
            Log.i("HOANG", "link: ${it[1].url}")
            mViewModel.bannerList.setData(it)
            Log.i("HOANG", "initBanner ${mViewModel.bannerList.getAllData()[0].url}")
            mFragment.mBinding?.progressBanner?.visibility = View.GONE
        })
        mViewModel.loadBanner()
    }

    private fun banners() {
        mFragment.mBinding?.viewpagerSlider?.adapter =
            BannerListAdapter(mFragment.mBinding!!.viewpagerSlider)
        mFragment.mBinding?.viewpagerSlider?.clipToPadding = false
        mFragment.mBinding?.viewpagerSlider?.clipChildren = false
        mFragment.mBinding?.viewpagerSlider?.offscreenPageLimit = 3
        mFragment.mBinding?.viewpagerSlider?.getChildAt(0)?.overScrollMode =
            RecyclerView.OVER_SCROLL_NEVER

        val compositePageTransformer = CompositePageTransformer().apply {
            addTransformer(MarginPageTransformer(40))
        }
        mFragment.mBinding?.viewpagerSlider?.setPageTransformer(compositePageTransformer)

        if (mViewModel.bannerList.getSize() > 1) {
            mFragment.mBinding?.dotIndicator?.visibility = View.VISIBLE
            mFragment.mBinding?.dotIndicator?.attachTo(mFragment.mBinding!!.viewpagerSlider)
        }
    }
}