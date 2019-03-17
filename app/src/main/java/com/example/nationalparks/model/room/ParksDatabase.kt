package com.example.nationalparks.model.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.nationalparks.model.data.ParkDao
import com.example.nationalparks.model.data.SurveyDao
import com.example.nationalparks.model.data.WeatherDao

@Database(entities = [Park::class, DataWeather::class, Survey::class], version = 1)
abstract class ParksDatabase : RoomDatabase() {
    abstract fun parkDao(): ParkDao
    abstract fun weatherDao(): WeatherDao
    abstract fun surveyDao(): SurveyDao
}