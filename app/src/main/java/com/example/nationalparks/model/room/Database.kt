package com.example.nationalparks.model.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.nationalparks.model.data.CampgroundDao
import com.example.nationalparks.model.data.ParkDao
import com.example.nationalparks.model.data.ReservationDao
import com.example.nationalparks.model.data.SiteDao

@Database(entities = [Park::class, Campground::class, Site::class, Reservation::class], version = 1)
abstract class Database : RoomDatabase() {
    abstract fun parkDao(): ParkDao
    abstract fun campgroundDao(): CampgroundDao
    abstract fun siteDao(): SiteDao
    abstract fun reservationDao(): ReservationDao
}