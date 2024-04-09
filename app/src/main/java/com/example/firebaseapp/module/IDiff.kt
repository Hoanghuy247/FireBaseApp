package com.example.firebaseapp.module

interface IDiff {
    fun areItemsTheSame(item : IDiff) : Boolean
    fun areContentsTheSame(item: IDiff) : Boolean
}