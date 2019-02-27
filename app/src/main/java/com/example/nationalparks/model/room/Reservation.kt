package com.example.nationalparks.model.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.util.*

@Entity(
    tableName = "reservation"
)
data class Reservation(
    @PrimaryKey
    val reservationId: Long,
    val siteId: Long,
    val name: String,
    val fromDate: Date,
    val toDate: Date,
    val createDate: Date) : Serializable