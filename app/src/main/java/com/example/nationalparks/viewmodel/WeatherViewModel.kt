package com.example.nationalparks.viewmodel

import androidx.lifecycle.ViewModel
import com.example.nationalparks.model.room.Weather

class WeatherViewModel (val weather: List<Weather>, var celsius: Boolean) : ViewModel() {


    init {
        updateWeather()
    }

    fun updateWeather() {
        for (each in weather) {
            each.updateTemps(celsius)
        }
    }
}