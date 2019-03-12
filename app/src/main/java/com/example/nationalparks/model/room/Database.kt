package com.example.nationalparks.model.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.nationalparks.model.data.ParkDao

@Database(entities = [Park::class], version = 2)
abstract class Database : RoomDatabase() {
    abstract fun parkDao(): ParkDao
}