package com.example.firebaseapp.base

import java.util.EnumMap

open class DelegateFactory<F: BaseFragment<*>, VM: BaseViewModel>(
    protected val fragment: F,
    protected val viewModel: VM
) {
    private val mapDelegate: EnumMap<KeyDelegate, BaseDelegate<F,VM>> = EnumMap(KeyDelegate::class.java)

    fun init() {
        createDelegateList().forEach {
            mapDelegate[it.first] = it.second
        }
    }

    fun onCreateView() {
        getDelegates().forEach {
            it.onCreateView()
        }
    }

    fun onViewCreated() {
        getDelegates().forEach {
            it.onViewCreated()
        }
    }

    fun onPause() {
        getDelegates().forEach {
            it.onPause()
        }
    }

    fun onResume() {
        getDelegates().forEach {
            it.onResume()
        }
    }

    fun onDestroy() {
        getDelegates().forEach {
            it.onDestroy()
        }
    }

    open fun createDelegateList() : List<Pair<KeyDelegate, BaseDelegate<F,VM>>>{
        return emptyList()
    }

    private fun getDelegates() : List<BaseDelegate<F, VM>> {
        return mapDelegate.values.toMutableList()
    }

    fun getDelegate(key: KeyDelegate) : BaseDelegate<F,VM>? {
        return mapDelegate[key]
    }
}