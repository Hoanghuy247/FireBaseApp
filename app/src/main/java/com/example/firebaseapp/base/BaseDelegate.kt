package com.example.firebaseapp.base

import android.app.Activity

open class BaseDelegate<F: BaseFragment<*>, VM: BaseViewModel>(
    val mFragment: F,
    val mViewModel: VM
) {
    protected val mActivity: Activity
        get() = mFragment.requireActivity()

    open fun onCreateView() {}
    open fun onViewCreated() {}
    open fun onResume() {}
    open fun onPause() {}
    open fun onDestroy() {}
}