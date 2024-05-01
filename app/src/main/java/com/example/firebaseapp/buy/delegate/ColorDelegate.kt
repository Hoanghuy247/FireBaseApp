package com.example.firebaseapp.buy.delegate

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.example.firebaseapp.base.BaseDelegate
import com.example.firebaseapp.base.baseRV.BaseRecyclerListener
import com.example.firebaseapp.buy.BuyFragment
import com.example.firebaseapp.buy.BuyViewModel
import com.example.firebaseapp.buy.adapter.ColorAdapter
import com.example.firebaseapp.buy.adapter.DetailAdapter
import com.example.firebaseapp.module.SliderModel

class ColorDelegate(f: BuyFragment, vm: BuyViewModel) :
    BaseDelegate<BuyFragment, BuyViewModel>(f,vm), BaseRecyclerListener<SliderModel> {

    override fun onViewCreated() {
        initAdapter()
    }

    private fun initAdapter() {
        mFragment.mBinding?.detailViewpager?.adapter = DetailAdapter().apply {
            setData(mViewModel.listColor)
        }
        mFragment.mBinding?.detailViewpager?.clipToPadding = false
        mFragment.mBinding?.detailViewpager?.clipChildren = false
        mFragment.mBinding?.detailViewpager?.offscreenPageLimit = 3
        mFragment.mBinding?.detailViewpager?.getChildAt(0)?.overScrollMode =
            RecyclerView.OVER_SCROLL_NEVER

        val compositePageTransformer = CompositePageTransformer().apply {
            addTransformer(MarginPageTransformer(40))
        }
        mFragment.mBinding?.detailViewpager?.setPageTransformer(compositePageTransformer)
        mFragment.mBinding?.dotIndicator?.visibility = View.VISIBLE
        mFragment.mBinding?.dotIndicator?.attachTo(mFragment.mBinding!!.detailViewpager)

        mFragment.mBinding?.rvChoseColor?.adapter = ColorAdapter().apply {
            setData(mViewModel.listColor)
            setListener(this@ColorDelegate)
        }
        mFragment.mBinding?.rvChoseColor?.layoutManager =
            LinearLayoutManager(mActivity, LinearLayoutManager.HORIZONTAL, false)
    }

    override fun itemClick(position: Int, item: SliderModel) {
        //save data color
    }
}