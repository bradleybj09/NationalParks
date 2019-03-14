package com.example.nationalparks.model.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(
    tableName = "park"
)
data class Park (
    @PrimaryKey
    val parkCode: String,
    val name: String,
    val state: String,
    val acreage: Int,
    val elevationInFeet: Int,
    val milesOfTrail: Double,
    val numberOfCampsites: Int,
    val climate: String,
    val yearFounded: Int,
    val annualVisitorCount: Int,
    val quote: String,
    val quoteSource: String,
    val description: String,
    val entryFee: Int,
    val numberOfAnimalSpecies: Int
) : Serializable {
    val entryFeeString = String.format("$%.2f", entryFee.toDouble())
}