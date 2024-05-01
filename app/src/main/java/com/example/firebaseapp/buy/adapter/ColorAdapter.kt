package com.example.firebaseapp.buy.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.example.firebaseapp.R
import com.example.firebaseapp.base.baseRV.BaseListAdapter
import com.example.firebaseapp.base.baseRV.BaseRecyclerListener
import com.example.firebaseapp.base.baseRV.BaseViewHolder
import com.example.firebaseapp.buy.data.ColorListData
import com.example.firebaseapp.databinding.ViewholderColorBinding
import com.example.firebaseapp.module.SliderModel

class ColorAdapter : BaseListAdapter<
        SliderModel,
        BaseRecyclerListener<SliderModel>,
        ColorListData>() {

    private var selectedPosition = -1
    private var lastSelectedPosition = -1

    override fun getItemViewBinding(parent: ViewGroup, viewType: Int): ViewBinding {
        return ViewholderColorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }

    override fun bindView(
        holder: BaseViewHolder<ViewBinding, SliderModel, BaseRecyclerListener<SliderModel>>,
        position: Int,
        item: SliderModel,
        lis: BaseRecyclerListener<SliderModel>?
    ) {
        holder.binding as ViewholderColorBinding

        Glide.with(holder.binding.vhColor.context)
            .load(item.url)
            .into(holder.binding.vhColor)

        holder.binding.root.setOnClickListener {
            lis?.itemClick(position, item)
            lastSelectedPosition = selectedPosition
            selectedPosition = position
            notifyItemChanged(selectedPosition)
            notifyItemChanged(lastSelectedPosition)
        }

        if (selectedPosition == position) {
            holder.binding.vhColor.setBackgroundResource(R.drawable.overlay_background)
        } else {
            holder.binding.vhColor.setBackgroundResource(R.drawable.grey_bg)
        }
    }
}