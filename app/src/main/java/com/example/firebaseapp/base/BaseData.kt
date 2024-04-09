package com.example.firebaseapp.base

import java.lang.Exception

open class BaseData<ITEM> {

    var data: List<ITEM> = emptyList()
        private set
    private val listenerList: ArrayList<OnDataChangeListener> = ArrayList()

    open fun  setData(data: List<ITEM>){
        this.data = data
        notifyDataChanged()
    }

    private fun notifyDataChanged() {
        for (listener in listenerList){
            listener.onDataChange()
        }
    }

    open fun getAllData() : List<ITEM> {
        return data
    }

    open fun getSize() = data.size

    open fun getItemAtPosition(position : Int) : ITEM? {
        return try {
            data[position]
        } catch (e: Exception){
            return null
        }
    }

    fun setOnDataChangedListener(listener: OnDataChangeListener) {
        listenerList.add(listener)
        listener.onDataChange()
    }

    fun removeOnDataChangedListener(listener: OnDataChangeListener) {
        listenerList.remove(listener)
        listener.onDataChange()
    }

    interface OnDataChangeListener{
        fun onDataChange()
    }
}