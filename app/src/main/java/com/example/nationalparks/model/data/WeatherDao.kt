package com.example.nationalparks.model.data

import androidx.room.Dao
import androidx.room.Query
import com.example.nationalparks.model.room.Weather

@Dao
interface WeatherDao {

    @Query("SELECT * FROM weather WHERE parkCode = :parkCode")
    fun getWeatherByParkCode(parkCode: String): List<Weather>
}