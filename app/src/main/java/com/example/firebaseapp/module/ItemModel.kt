package com.example.firebaseapp.module

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ItemModel(
    var title: String = "",
    var description: String = "",
    var picUrl: ArrayList<String> = ArrayList(),
    var size: ArrayList<String> = ArrayList(),
    var price: Double = 0.0,
    var rating: Double = 0.0,
    var numberInCart: Int = 0
) : Parcelable, IDiff {
    override fun areItemsTheSame(item: IDiff): Boolean {
        return if (item is ItemModel) {
            title == item.title
        } else {
            false
        }
    }

    override fun areContentsTheSame(item: IDiff): Boolean {
        return if (item is ItemModel) {
            title == item.title && picUrl == item.picUrl
        } else {
            false
        }
    }

}
