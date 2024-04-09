package com.example.firebaseapp.home.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.bumptech.glide.request.RequestOptions
import com.example.firebaseapp.base.baseRV.BaseListAdapter
import com.example.firebaseapp.base.baseRV.BaseRecyclerListener
import com.example.firebaseapp.base.baseRV.BaseViewHolder
import com.example.firebaseapp.databinding.SliderItemContainerBinding
import com.example.firebaseapp.home.data.BannerListData
import com.example.firebaseapp.module.SliderModel

class BannerListAdapter(val viewPager2: ViewPager2) : BaseListAdapter<
        SliderModel,
        BaseRecyclerListener<SliderModel>,
        BannerListData>() {

    override fun bindView(
        holder: BaseViewHolder<ViewBinding, SliderModel, BaseRecyclerListener<SliderModel>>,
        position: Int,
        item: SliderModel,
        lis: BaseRecyclerListener<SliderModel>?
    ) {
        bindBanner(holder, position, item, lis)
    }

    override fun getItemViewBinding(parent: ViewGroup, viewType: Int): ViewBinding {
        return  SliderItemContainerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }

    private fun bindBanner(
        holder: BaseViewHolder<ViewBinding, SliderModel, BaseRecyclerListener<SliderModel>>,
        position: Int,
        item: SliderModel,
        lis: BaseRecyclerListener<SliderModel>?
    ) {
        Log.i("HOANG", "bindBannerView: ${item.url}")
        holder.binding as SliderItemContainerBinding

        Glide.with(holder.binding.imageSlider.context)
            .load(item.url)
            .into(holder.binding.imageSlider)
    }

}