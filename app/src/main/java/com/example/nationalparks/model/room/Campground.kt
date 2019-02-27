package com.example.nationalparks.model.room

import android.icu.math.BigDecimal
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(
    tableName = "campground"
)
data class Campground(
    @PrimaryKey
    val campgroundId: Long,
    val parkId: Long,
    val name: String,
    val openFromMonth: Int,
    val openToMonth: Int,
    val dailyFee: BigDecimal) : Serializable