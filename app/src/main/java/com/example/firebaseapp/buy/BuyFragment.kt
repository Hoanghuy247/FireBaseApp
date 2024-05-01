package com.example.firebaseapp.buy

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.firebaseapp.base.BaseFragment
import com.example.firebaseapp.base.DelegateFactory
import com.example.firebaseapp.buy.delegate.BuyDelegateFactory
import com.example.firebaseapp.databinding.FragmentBuyBinding

class BuyFragment : BaseFragment<FragmentBuyBinding>(FragmentBuyBinding::inflate) {

    val args: BuyFragmentArgs by navArgs()

    override val mViewModel: BuyViewModel by viewModels()
    override val mDelegateFactory: DelegateFactory<*,*> by lazy {
        BuyDelegateFactory(this, mViewModel)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel.getItemModel(args.ItemModel)
        mViewModel.setItemModel()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding?.back?.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}