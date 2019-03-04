package com.example.nationalparks.model.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.time.LocalDate
import java.util.*

@Entity(
    tableName = "reservation"
)
data class Reservation(
    @PrimaryKey
    val reservationId: Long,
    val siteId: Long,
    val name: String,
    val fromDate: LocalDate,
    val toDate: LocalDate,
    val createDate: LocalDate) : Serializable