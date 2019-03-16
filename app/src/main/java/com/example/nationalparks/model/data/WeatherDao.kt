package com.example.nationalparks.model.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.nationalparks.model.room.Weather
import io.reactivex.Observable

@Dao
interface WeatherDao {

    @Query("SELECT * FROM weather WHERE parkCode = :parkCode")
    fun getWeatherByParkCode(parkCode: String): Observable<List<Weather>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWeather(weather: List<Weather>)
}