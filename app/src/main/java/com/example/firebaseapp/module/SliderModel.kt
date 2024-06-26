package com.example.firebaseapp.module

data class SliderModel(val url: String = "") : IDiff {

    override fun areItemsTheSame(item: IDiff): Boolean {
        return if (item is SliderModel) {
            url == item.url
        } else {
            false
        }
    }

    override fun areContentsTheSame(item: IDiff): Boolean {
        return if (item is SliderModel) {
            url == item.url
        } else {
            false
        }
    }
}
