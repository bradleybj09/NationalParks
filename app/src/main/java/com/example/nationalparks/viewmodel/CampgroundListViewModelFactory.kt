package com.example.nationalparks.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CampgroundListViewModelFactory(val parkId: Long) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CampgroundListViewModel(parkId) as T
    }
}