package com.example.firebaseapp.buy.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.example.firebaseapp.base.baseRV.BaseListAdapter
import com.example.firebaseapp.base.baseRV.BaseRecyclerListener
import com.example.firebaseapp.base.baseRV.BaseViewHolder
import com.example.firebaseapp.buy.data.ColorListData
import com.example.firebaseapp.databinding.ViewholderDetailViewpager2Binding
import com.example.firebaseapp.module.SliderModel

class DetailAdapter : BaseListAdapter<
        SliderModel,
        BaseRecyclerListener<SliderModel>,
        ColorListData>() {

    override fun getItemViewBinding(parent: ViewGroup, viewType: Int): ViewBinding {
        return ViewholderDetailViewpager2Binding.inflate(LayoutInflater.from(parent.context), parent, false)
    }

    override fun bindView(
        holder: BaseViewHolder<ViewBinding, SliderModel, BaseRecyclerListener<SliderModel>>,
        position: Int,
        item: SliderModel,
        lis: BaseRecyclerListener<SliderModel>?
    ) {
        holder.binding as ViewholderDetailViewpager2Binding

        Glide.with(holder.binding.popular.context)
            .load(item.url)
            .into(holder.binding.popular)
    }
}