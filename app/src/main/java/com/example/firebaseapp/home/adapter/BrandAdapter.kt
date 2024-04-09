package com.example.firebaseapp.home.adapter

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.ImageViewCompat
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.example.firebaseapp.R
import com.example.firebaseapp.base.baseRV.BaseListAdapter
import com.example.firebaseapp.base.baseRV.BaseRecyclerListener
import com.example.firebaseapp.base.baseRV.BaseViewHolder
import com.example.firebaseapp.databinding.ViewholderBrandBinding
import com.example.firebaseapp.home.data.BrandListData
import com.example.firebaseapp.module.BrandModel

class BrandAdapter : BaseListAdapter<
        BrandModel,
        BaseRecyclerListener<BrandModel>,
        BrandListData> (){

    private var selectedPosition = -1
    private var lastSelectedPosition = -1

    override fun getItemViewBinding(parent: ViewGroup, viewType: Int): ViewBinding {
        return ViewholderBrandBinding.inflate(LayoutInflater.from(parent.context),parent, false)
    }

    override fun bindView(
        holder: BaseViewHolder<ViewBinding, BrandModel, BaseRecyclerListener<BrandModel>>,
        position: Int,
        item: BrandModel,
        lis: BaseRecyclerListener<BrandModel>?
    ) {
        bindViewBrand(holder, position, item, lis)
    }

    private fun bindViewBrand(
        holder: BaseViewHolder<ViewBinding, BrandModel, BaseRecyclerListener<BrandModel>>,
        position: Int,
        item: BrandModel,
        lis: BaseRecyclerListener<BrandModel>?
    ) {
        holder.binding as ViewholderBrandBinding

        holder.binding.title.text = item.title

        Glide.with(holder.binding.imageView4.context)
            .load(item.picUrl)
            .into(holder.binding.imageView4)

        holder.binding.root.setOnClickListener {
            lastSelectedPosition = selectedPosition
            selectedPosition = position
            notifyItemChanged(lastSelectedPosition)
            notifyItemChanged(selectedPosition)
        }

        if (selectedPosition == position) {
            holder.binding.imageView4.setBackgroundResource(0)
            holder.binding.mainLayout.setBackgroundResource(R.drawable.purple_button_bg)
            ImageViewCompat.setImageTintList(holder.binding.imageView4, ColorStateList.valueOf(Color.parseColor("#FFFFFFFF")))
            holder.binding.title.visibility = View.VISIBLE
        } else {
            holder.binding.imageView4.setBackgroundResource(R.drawable.grey_bg)
            holder.binding.mainLayout.setBackgroundResource(0)
            ImageViewCompat.setImageTintList(holder.binding.imageView4, ColorStateList.valueOf(Color.parseColor("#FF000000")))
            holder.binding.title.visibility = View.GONE
        }
    }
}