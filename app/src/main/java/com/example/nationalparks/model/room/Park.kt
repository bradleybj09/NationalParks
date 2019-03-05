package com.example.nationalparks.model.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.time.LocalDate
import java.util.*

@Entity(
    tableName = "park"
)
data class Park (
    @PrimaryKey
    val parkId: Long,
    val name: String,
    val location: String,
    val establishDate: LocalDate,
    val area: Long,
    val visitors: Int,
    val description: String) : Serializable