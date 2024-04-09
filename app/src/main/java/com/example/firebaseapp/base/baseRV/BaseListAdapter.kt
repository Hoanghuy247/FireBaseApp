package com.example.firebaseapp.base.baseRV

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.viewbinding.ViewBinding
import com.example.firebaseapp.base.BaseData
import com.example.firebaseapp.base.BaseListener
import com.example.firebaseapp.module.IDiff
import com.example.firebaseapp.module.SliderModel
import java.lang.Exception

abstract class BaseListAdapter<
        ITEM: IDiff,
        LIS: BaseListener,
        DATA: BaseData<ITEM>> :
    ListAdapter<ITEM, BaseViewHolder<ViewBinding, ITEM, LIS>>(BaseDiffCallBack<ITEM>()){

    protected var data: DATA? = null
        private set

    var listener: LIS? = null
        private set

    private val onDataChangeListener = object : BaseData.OnDataChangeListener{
        override fun onDataChange() {
            submitList(data?.getAllData())
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<ViewBinding, ITEM, LIS> {
        return BaseViewHolder(getItemViewBinding(parent, viewType))
    }

    abstract fun getItemViewBinding(parent: ViewGroup, viewType: Int): ViewBinding

    override fun onBindViewHolder(holder: BaseViewHolder<ViewBinding, ITEM, LIS>, position: Int) {
        try {
            getItemAtPosition(position)?.let{ bindView(holder, position, it, listener )}
        }catch (e: Exception){

        }
    }

    open fun getItemAtPosition(position: Int): ITEM? {
        return data?.getItemAtPosition(position)
    }

    abstract fun bindView(
        holder: BaseViewHolder<ViewBinding, ITEM, LIS>,
        position: Int,
        item: ITEM,
        lis: LIS?
    )

    fun notifyDataChange(){
        submitList(data?.getAllData())
    }

    open fun setData(data: DATA?) {
        this.data?.removeOnDataChangedListener(onDataChangeListener)
        this.data = data
        this.data?.setOnDataChangedListener(onDataChangeListener)
    }

    fun setListener(listener: LIS?, update: Boolean = true) {
        this.listener = listener
        if (update) {
            notifyDataSetChanged()
        }
    }

    fun onDestroy() {
        this.data?.removeOnDataChangedListener(onDataChangeListener)
    }
}