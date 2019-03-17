package com.example.nationalparks.model.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.nationalparks.model.room.DataWeather
import io.reactivex.Observable

@Dao
interface WeatherDao {

    @Query("SELECT * FROM weather WHERE parkCode = :parkCode")
    fun getWeatherByParkCode(parkCode: String): Observable<List<DataWeather>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWeather(weather: List<DataWeather>)
}