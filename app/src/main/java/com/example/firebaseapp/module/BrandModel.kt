package com.example.firebaseapp.module

data class BrandModel(
    val title: String = "",
    val id: Int = 0,
    val picUrl: String = ""
) : IDiff {
    override fun areItemsTheSame(item: IDiff): Boolean {
        TODO("Not yet implemented")
    }

    override fun areContentsTheSame(item: IDiff): Boolean {
        TODO("Not yet implemented")
    }
}

