package com.example.nationalparks.model.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.nationalparks.model.room.Park
import io.reactivex.Observable

@Dao
interface ParkDao {

    @Query("SELECT * FROM park")
    fun getParks(): Observable<List<Park>>

    @Query("SELECT * FROM park WHERE parkCode = :parkCode")
    fun getParkByCode(parkCode: String): Observable<Park>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertParks(parks: List<Park>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPark(park: Park)
}