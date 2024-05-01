package com.example.firebaseapp.buy

import android.app.Application
import com.example.firebaseapp.base.BaseViewModel
import com.example.firebaseapp.buy.data.ColorListData
import com.example.firebaseapp.buy.data.SizeListData
import com.example.firebaseapp.module.ItemModel
import com.example.firebaseapp.module.SizeModel
import com.example.firebaseapp.module.SliderModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BuyViewModel  @Inject constructor(application: Application) : BaseViewModel(application) {

    val listColor = ColorListData()
    val listSize = SizeListData()

    var price = 0
    var description = ""
    var shoesName = ""
    var rate: Double = 0.0

    var itemModel: ItemModel? = null
        private set

    fun getItemModel(itemModel: ItemModel){
        this.itemModel = itemModel
    }

    fun setItemModel() {
        val listColorTemp = mutableListOf<SliderModel>()
        itemModel?.picUrl?.forEach {
            listColorTemp.add(SliderModel(it))
        }
        listColor.setData(listColorTemp)

        val listSizeTemp = mutableListOf<SizeModel>()
        itemModel?.size?.forEach {
            listSizeTemp.add(SizeModel(it))
        }
        listSize.setData(listSizeTemp)

        price = itemModel!!.price.toInt()
        description = itemModel!!.description
        shoesName = itemModel!!.title
        rate = itemModel!!.rating
    }
}