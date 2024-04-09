package com.example.firebaseapp.home

import androidx.fragment.app.viewModels
import com.example.firebaseapp.base.BaseFragment
import com.example.firebaseapp.base.DelegateFactory
import com.example.firebaseapp.databinding.FragmentHomeBinding
import com.example.firebaseapp.home.delegate.HomeDelegateFactory
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    override val mViewModel: HomeViewModel by viewModels()
    override val mDelegateFactory: DelegateFactory<*, *> by lazy {
        HomeDelegateFactory(this, mViewModel)
    }

}