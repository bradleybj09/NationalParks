package com.example.nationalparks.model.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.nationalparks.model.data.ParkDao
import com.example.nationalparks.model.data.WeatherDao

@Database(entities = [Park::class, Weather::class], version = 3)
abstract class Database : RoomDatabase() {
    abstract fun parkDao(): ParkDao
    abstract fun weatherDao(): WeatherDao
}