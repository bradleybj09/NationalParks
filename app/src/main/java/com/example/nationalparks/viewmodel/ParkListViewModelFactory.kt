package com.example.nationalparks.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class ParkListViewModelFactory @Inject constructor(private val parkListViewModel: ParkListViewModel) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ParkListViewModel::class.java)) {
            return parkListViewModel as T
        } else {
            throw IllegalArgumentException("Unknown class name")
        }
    }
}