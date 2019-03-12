package com.example.nationalparks.viewmodel

import androidx.lifecycle.ViewModel
import com.example.nationalparks.model.ParkRepository
import com.example.nationalparks.util.Weather

class WeatherViewModel(val parkId: Long) : ViewModel() {

    val weather: List<Weather>

    init {
        val repository = ParkRepository()
        weather = repository.getWeatherByParkId(parkId)
    }
}