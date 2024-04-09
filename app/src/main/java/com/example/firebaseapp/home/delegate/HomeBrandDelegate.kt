package com.example.firebaseapp.home.delegate

import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firebaseapp.base.BaseDelegate
import com.example.firebaseapp.home.HomeFragment
import com.example.firebaseapp.home.HomeViewModel
import com.example.firebaseapp.home.adapter.BrandAdapter

class HomeBrandDelegate (f: HomeFragment, vm: HomeViewModel) :
    BaseDelegate<HomeFragment, HomeViewModel>(f,vm) {

    override fun onCreateView() {
        initBrand()
    }

    private fun initBrand() {
        mFragment.mBinding?.progressBar2?.visibility = View.VISIBLE
        mViewModel.brands.observe(mFragment.viewLifecycleOwner, Observer {
            mViewModel.brandList.setData(it)
            Log.i("HOANG", "initBrand: ${mViewModel.brandList.getSize()}")
            mFragment.mBinding?.recyclerViewBrand?.layoutManager = LinearLayoutManager(mActivity, LinearLayoutManager.HORIZONTAL, false)
            mFragment.mBinding?.recyclerViewBrand?.adapter = BrandAdapter()
            mFragment.mBinding?.progressBar2?.visibility = View.GONE
        })
        mViewModel.loadBrands()
    }
}