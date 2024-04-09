package com.example.firebaseapp.home.delegate

import com.example.firebaseapp.base.BaseDelegate
import com.example.firebaseapp.base.DelegateFactory
import com.example.firebaseapp.base.KeyDelegate
import com.example.firebaseapp.home.HomeFragment
import com.example.firebaseapp.home.HomeViewModel

class HomeDelegateFactory(f: HomeFragment, vm: HomeViewModel) :
    DelegateFactory<HomeFragment, HomeViewModel>(f, vm){

    override fun createDelegateList(): List<Pair<KeyDelegate, BaseDelegate<HomeFragment, HomeViewModel>>> {
        return mutableListOf(
            Pair(KeyDelegate.HOME_BANNER, HomeBannerDelegate(fragment, viewModel)),
            Pair(KeyDelegate.HOME_BRAND, HomeBrandDelegate(fragment, viewModel)),
            Pair(KeyDelegate.HOME_RECOMMENDATION, HomeRecommendDelegate(fragment, viewModel))
        )
    }
}