package com.example.firebaseapp.home

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.firebaseapp.base.BaseViewModel
import com.example.firebaseapp.home.data.BannerListData
import com.example.firebaseapp.home.data.BrandListData
import com.example.firebaseapp.home.data.RecommendationListData
import com.example.firebaseapp.module.BrandModel
import com.example.firebaseapp.module.ItemModel
import com.example.firebaseapp.module.SliderModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(application: Application) : BaseViewModel(application){

    private val firebaseDatabase = FirebaseDatabase.getInstance()
    private val _banner = MutableLiveData<List<SliderModel>>()
    private val _brand = MutableLiveData<List<BrandModel>>()
    private val _recommendation = MutableLiveData<List<ItemModel>>()

    val banners : LiveData<List<SliderModel>> = _banner
    val brands : LiveData<List<BrandModel>> = _brand
    val recommendations: LiveData<List<ItemModel>> = _recommendation

    val bannerList = BannerListData()
    val brandList = BrandListData()
    val recommendationList = RecommendationListData()

    fun loadBanner() {
        val ref = firebaseDatabase.getReference("Banner")
        ref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val lists = mutableListOf<SliderModel>()
                for (childSnapshot in snapshot.children) {
                    val list = childSnapshot.getValue(SliderModel::class.java)
                    if (list != null) {
                        lists.add(list)
                    }
                }
                _banner.value = lists
                Log.i("HOANG", "banner: ${banners.value?.size}")
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

    fun loadBrands() {
        val Ref = firebaseDatabase.getReference("Category")
        Ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val lists = mutableListOf<BrandModel>()
                for (childSnapshot in snapshot.children) {
                    val list = childSnapshot.getValue(BrandModel::class.java)
                    if (list != null) {
                        lists.add(list)
                    }
                }
                _brand.value = lists
                Log.i("HOANG", "brand: ${brands.value?.size}")
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

    fun loadRecommendation() {
        val Ref = firebaseDatabase.getReference("Items")
        Ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val lists = mutableListOf<ItemModel>()
                for (childSnapshot in snapshot.children) {
                    val list = childSnapshot.getValue(ItemModel::class.java)
                    if (list != null) {
                        lists.add(list)
                    }
                }
                _recommendation.value = lists
                Log.i("HOANG", "recommend: ${recommendations.value?.size}")
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}