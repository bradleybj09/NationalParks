package com.example.nationalparks.util

import com.example.nationalparks.model.room.DataWeather
import com.example.nationalparks.model.room.Weather

class WeatherConverter {

    companion object {
        fun convert(dataWeather: List<DataWeather>): List<Weather> {
            val weather: MutableList<Weather> = ArrayList()
            for (each in dataWeather) {
                weather.add(Weather(each.parkCode,each.day,each.lowTemp,each.highTemp,each.forecast))
            }
            return weather
        }
    }
}