package com.example.firebaseapp.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions
import com.example.firebaseapp.base.baseRV.BaseListAdapter
import com.example.firebaseapp.base.baseRV.BaseRecyclerListener
import com.example.firebaseapp.base.baseRV.BaseViewHolder
import com.example.firebaseapp.databinding.ViewholderRecommendationBinding
import com.example.firebaseapp.home.data.RecommendationListData
import com.example.firebaseapp.module.ItemModel

class RecommendationAdapter : BaseListAdapter<
        ItemModel,
        BaseRecyclerListener<ItemModel>,
        RecommendationListData>() {

    override fun getItemViewBinding(parent: ViewGroup, viewType: Int): ViewBinding {
        return ViewholderRecommendationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }

    override fun bindView(
        holder: BaseViewHolder<ViewBinding, ItemModel, BaseRecyclerListener<ItemModel>>,
        position: Int,
        item: ItemModel,
        lis: BaseRecyclerListener<ItemModel>?
    ) {
        holder.binding as ViewholderRecommendationBinding

        holder.binding.title.text = item.title
        holder.binding.price.text = "$" + item.price
        holder.binding.rate.text = item.rating.toString()

        Glide.with(holder.itemView.context)
            .load(item.picUrl)
            .apply(RequestOptions().transform(CenterCrop()))
            .into(holder.binding.pic)
    }
}