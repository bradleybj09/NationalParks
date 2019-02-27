package com.example.nationalparks.model.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.nationalparks.model.room.Campground

@Dao
interface CampgroundDao {

    @Query("SELECT * FROM campground")
    fun getCampgrounds(): LiveData<List<Campground>>
}