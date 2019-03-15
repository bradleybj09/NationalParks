package com.example.nationalparks.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class WeatherViewModelFactory @Inject constructor(val weatherViewModel: WeatherViewModel) : ViewModelProvider.Factory{

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WeatherViewModel::class.java)) {
            return weatherViewModel as T
        } else {
            throw IllegalArgumentException("Unknown class name")
        }
    }
}