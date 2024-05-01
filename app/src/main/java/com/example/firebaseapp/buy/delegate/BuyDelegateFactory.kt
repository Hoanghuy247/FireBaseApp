package com.example.firebaseapp.buy.delegate

import com.example.firebaseapp.base.BaseDelegate
import com.example.firebaseapp.base.DelegateFactory
import com.example.firebaseapp.base.KeyDelegate
import com.example.firebaseapp.buy.BuyFragment
import com.example.firebaseapp.buy.BuyViewModel

class BuyDelegateFactory(f: BuyFragment, vm: BuyViewModel) :
    DelegateFactory<BuyFragment, BuyViewModel>(f,vm) {

    override fun createDelegateList(): List<Pair<KeyDelegate, BaseDelegate<BuyFragment, BuyViewModel>>> {
        return mutableListOf(
            Pair(KeyDelegate.COLOR, ColorDelegate(fragment, viewModel)),
            Pair(KeyDelegate.SIZE, SizeDelegate(fragment, viewModel))
        )
    }
}