package com.example.nationalparks.viewmodel

import androidx.lifecycle.ViewModel
import com.example.nationalparks.model.ParkRepository
import com.example.nationalparks.model.room.Weather
import javax.inject.Inject

class WeatherViewModel @Inject constructor(val repository: ParkRepository) : ViewModel() {

    lateinit var weather: List<Weather>
    var celsius = false

    fun setup(parkCode: String) {
        weather = repository.getWeatherByParkCode(parkCode)
        celsius = repository.getTemperaturePreference()
        updateWeather()
    }

    fun updateWeather() {
        for (each in weather) {
            each.updateTemps(celsius)
        }
    }
}