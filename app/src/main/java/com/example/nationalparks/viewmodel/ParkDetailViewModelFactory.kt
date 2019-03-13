package com.example.nationalparks.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ParkDetailViewModelFactory(val parkCode: String) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ParkDetailViewModel(parkCode) as T
    }
}