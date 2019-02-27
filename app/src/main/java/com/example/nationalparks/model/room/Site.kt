package com.example.nationalparks.model.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(
    tableName = "site"
)
data class Site (
    @PrimaryKey
    val siteId: Long,
    val campgroundId: Long,
    val siteNumber: Int,
    val maxOccupancy: Int,
    val accessible: Boolean,
    val maxRvLength: Int,
    val utilities: Boolean) : Serializable