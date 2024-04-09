package com.example.firebaseapp.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding

typealias InflateActivity<T> = (LayoutInflater) -> T

abstract class BaseActivity<B: ViewDataBinding>(private val inflater: InflateActivity<B>) :
    AppCompatActivity() {

    lateinit var mBinding: B
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = inflater.invoke(layoutInflater)
        setContentView(mBinding.root)
    }
}