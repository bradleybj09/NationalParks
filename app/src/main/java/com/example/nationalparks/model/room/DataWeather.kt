package com.example.nationalparks.model.room

import androidx.room.Entity
import com.squareup.moshi.JsonClass
import java.io.Serializable

@Entity(tableName = "weather", primaryKeys = ["parkCode", "day"])
@JsonClass(generateAdapter = true)
data class DataWeather(
    val parkCode: String,
    val day: Int,
    val highTemp: Int,
    val lowTemp: Int,
    val forecast: String) : Serializable