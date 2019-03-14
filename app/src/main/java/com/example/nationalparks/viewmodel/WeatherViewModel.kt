package com.example.nationalparks.viewmodel

import androidx.lifecycle.ViewModel
import com.example.nationalparks.model.ParkRepository
import com.example.nationalparks.model.room.Weather

class WeatherViewModel(val parkCode: String) : ViewModel() {

    val weather: List<Weather>

    init {
        val repository = ParkRepository()
        weather = repository.getWeatherByParkCode(parkCode)
    }
}