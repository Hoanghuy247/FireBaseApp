package com.example.firebaseapp.module

data class BrandModel(
    val title: String = "",
    val id: Int = 0,
    val picUrl: String = ""
) : IDiff {
    override fun areItemsTheSame(item: IDiff): Boolean {
        return if (item is BrandModel) {
            id == item.id
        } else {
            false
        }
    }

    override fun areContentsTheSame(item: IDiff): Boolean {
        return if (item is BrandModel) {
            title == item.title && id == item.id && picUrl == item.picUrl
        } else {
            false
        }
    }
}

