package com.example.nationalparks.model.room

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.io.Serializable

@Entity(tableName = "park")
@JsonClass(generateAdapter = true)
data class Park (
    @PrimaryKey
    val parkCode: String,
    @Json(name = "parkName")
    val name: String,
    val state: String,
    val acreage: Int,
    @Json(name = "elevation")
    val elevationInFeet: Int,
    val milesOfTrail: Double,
    @Json(name = "numOfCampsites")
    val numberOfCampsites: Int,
    val climate: String,
    val yearFounded: Int,
    @Json(name = "annualVisitors")
    val annualVisitorCount: Int,
    val quote: String,
    val quoteSource: String,
    val description: String,
    val entryFee: Int,
    @Json(name = "numOfSpecies")
    val numberOfAnimalSpecies: Int
) : Serializable {
    @Ignore
    val entryFeeString = String.format("$%.2f", entryFee.toDouble())
}