package com.example.nationalparks.model.room

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiWeather(val parkCode: String, val day: Int, val highTemp: Int, val lowTemp: Int, val forecast: String) {

}