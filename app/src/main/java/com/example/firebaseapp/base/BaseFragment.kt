package com.example.firebaseapp.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint

typealias InflateFragment<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseFragment<B : ViewDataBinding>(private val inflater: InflateFragment<B>) :
    Fragment() {

    private var _binding: B? = null
    val mBinding get() = _binding

    abstract val mViewModel : BaseViewModel
    open val mDelegateFactory : DelegateFactory<*,*> by lazy {
        DelegateFactory(this, mViewModel)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflater(inflater, container, false)
        mBinding?.lifecycleOwner = viewLifecycleOwner
        mDelegateFactory.init()
        mDelegateFactory.onCreateView()
        return mBinding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (!mViewModel.isViewCreated) {
            mViewModel.setViewCreated(true)
        }
        mDelegateFactory.onViewCreated()
        onBindView()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun activity() : BaseActivity<*> {
        return requireActivity() as BaseActivity<*>
    }

    fun getDelegate(key: KeyDelegate): BaseDelegate<*,*>? {
        return mDelegateFactory.getDelegate(key)
    }

    open fun onBindView() {}
}