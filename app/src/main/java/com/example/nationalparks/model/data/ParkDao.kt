package com.example.nationalparks.model.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.nationalparks.model.room.Park

@Dao
interface ParkDao {

    @Query("SELECT * FROM park")
    fun getParks(): LiveData<List<Park>>
}