package com.example.firebaseapp.base.baseRV

import com.example.firebaseapp.base.BaseListener

interface BaseRecyclerListener<I> : BaseListener {
    fun itemClick(position: Int, item: I) {}
    fun itemLongClick(position: Int, item: I) {}
}