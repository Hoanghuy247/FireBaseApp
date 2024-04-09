package com.example.firebaseapp.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel

open class BaseViewModel(val app: Application) : AndroidViewModel(app) {

    var isViewCreated: Boolean = false
        private set

    init {
        setViewCreated(false)
    }

    fun setViewCreated(done: Boolean) {
        isViewCreated = done
    }
}