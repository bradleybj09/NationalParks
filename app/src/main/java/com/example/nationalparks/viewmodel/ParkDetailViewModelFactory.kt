package com.example.nationalparks.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class ParkDetailViewModelFactory @Inject constructor(private val parkDetailViewModel: ParkDetailViewModel) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ParkDetailViewModel::class.java)) {
            return parkDetailViewModel as T
        } else {
            throw IllegalArgumentException("Unknown class name")
        }
    }
}