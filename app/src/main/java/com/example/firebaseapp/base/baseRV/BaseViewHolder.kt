package com.example.firebaseapp.base.baseRV

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.firebaseapp.base.BaseListener
import com.example.firebaseapp.module.IDiff

class BaseViewHolder<
        B: ViewBinding,
        ITEM: IDiff,
        LIS: BaseListener> (val binding: B): RecyclerView.ViewHolder(binding.root) {
}