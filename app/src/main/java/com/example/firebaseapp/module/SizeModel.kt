package com.example.firebaseapp.module

data class SizeModel(val size: String = "") : IDiff{

    override fun areItemsTheSame(item: IDiff): Boolean {
        return if (item is SizeModel) {
            size == item.size
        } else {
            false
        }
    }

    override fun areContentsTheSame(item: IDiff): Boolean {
        return if (item is SizeModel) {
            size == item.size
        } else {
            false
        }
    }

}
