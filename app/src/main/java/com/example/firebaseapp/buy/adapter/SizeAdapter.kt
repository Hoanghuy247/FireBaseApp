package com.example.firebaseapp.buy.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.example.firebaseapp.R
import com.example.firebaseapp.base.baseRV.BaseListAdapter
import com.example.firebaseapp.base.baseRV.BaseRecyclerListener
import com.example.firebaseapp.base.baseRV.BaseViewHolder
import com.example.firebaseapp.buy.data.SizeListData
import com.example.firebaseapp.databinding.ViewholderSizeBinding
import com.example.firebaseapp.module.SizeModel

class SizeAdapter : BaseListAdapter<
        SizeModel,
        BaseRecyclerListener<SizeModel>,
        SizeListData>() {

    private var selectedPosition = -1
    private var lastSelectedPosition = -1

    override fun getItemViewBinding(parent: ViewGroup, viewType: Int): ViewBinding {
        return ViewholderSizeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }

    override fun bindView(
        holder: BaseViewHolder<ViewBinding, SizeModel, BaseRecyclerListener<SizeModel>>,
        position: Int,
        item: SizeModel,
        lis: BaseRecyclerListener<SizeModel>?
    ) {
        holder.binding as ViewholderSizeBinding
        holder.binding.vhSize.text = item.size

        holder.binding.root.setOnClickListener {
            lis?.itemClick(position, item)
            lastSelectedPosition = selectedPosition
            selectedPosition = position
            notifyItemChanged(selectedPosition)
            notifyItemChanged(lastSelectedPosition)
        }

        if (selectedPosition == position) {
            holder.binding.size.setBackgroundResource(R.drawable.overlay_background)
        } else {
            holder.binding.size.setBackgroundResource(R.drawable.grey_bg)
        }
    }
}