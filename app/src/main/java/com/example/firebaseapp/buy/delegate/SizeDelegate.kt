package com.example.firebaseapp.buy.delegate

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firebaseapp.base.BaseDelegate
import com.example.firebaseapp.base.baseRV.BaseRecyclerListener
import com.example.firebaseapp.buy.BuyFragment
import com.example.firebaseapp.buy.BuyViewModel
import com.example.firebaseapp.buy.adapter.SizeAdapter
import com.example.firebaseapp.module.SizeModel

class SizeDelegate(f: BuyFragment, vm: BuyViewModel) :
    BaseDelegate<BuyFragment, BuyViewModel>(f,vm), BaseRecyclerListener<SizeModel> {

    override fun onViewCreated() {
        super.onViewCreated()
        initView()
    }

    private fun initView() {
        mFragment.mBinding?.rvChooseSize?.adapter = SizeAdapter().apply {
            setData(mViewModel.listSize)
            setListener(this@SizeDelegate)
        }
        mFragment.mBinding?.rvChooseSize?.layoutManager =
            LinearLayoutManager(mActivity, LinearLayoutManager.HORIZONTAL, false)

        mFragment.mBinding?.shoesPrice?.text = "$" + mViewModel.price.toString()
        mFragment.mBinding?.shoesName?.text = mViewModel.shoesName
        mFragment.mBinding?.rate?.text = mViewModel.rate.toString()
        mFragment.mBinding?.description?.text = mViewModel.description
    }

    override fun itemClick(position: Int, item: SizeModel) {
        //Save size
    }
}