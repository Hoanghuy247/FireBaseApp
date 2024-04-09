package com.example.firebaseapp.base.baseRV

import androidx.recyclerview.widget.DiffUtil
import com.example.firebaseapp.module.IDiff

class BaseDiffCallBack<T: IDiff> : DiffUtil.ItemCallback<T>(){

    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem.areItemsTheSame(newItem)
    }

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem.areContentsTheSame(newItem)
    }
}