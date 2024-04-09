package com.example.firebaseapp.module

data class ItemModel(
    var title: String = "",
    var description: String = "",
    var picUrl: ArrayList<String> = ArrayList(),
    var size: ArrayList<String> = ArrayList(),
    var price: Double = 0.0,
    var rating: Double = 0.0,
    var numberInCart: Int = 0
) : IDiff {
    override fun areItemsTheSame(item: IDiff): Boolean {
        TODO("Not yet implemented")
    }

    override fun areContentsTheSame(item: IDiff): Boolean {
        TODO("Not yet implemented")
    }

}
