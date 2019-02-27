package com.example.nationalparks.model.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.nationalparks.model.room.Reservation

@Dao
interface ReservationDao {

    @Query("SELECT * FROM reservation WHERE siteId = :siteId")
    fun getReservationsBySiteId(siteId: Long): LiveData<List<Reservation>>

    @Query("SELECT * FROM reservation WHERE name = :name")
    fun getReservationsByNameOnReservation(name: String): LiveData<List<Reservation>>

    @Query("SELECT * FROM reservation WHERE reservationId = :reservationId")
    fun getReservationByReservationId(reservationId: Long): LiveData<Reservation>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun createReservation(reservation: Reservation)
}