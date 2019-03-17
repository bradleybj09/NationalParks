package com.example.nationalparks.model.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass
import java.io.Serializable

@Entity(tableName = "survey")
@JsonClass(generateAdapter = true)
data class Survey(
    val surveyID: Long,
    val parkCode: String,
    @PrimaryKey
    val email: String,
    val emailConfirmation: String,
    val state: String,
    val activityLevel: String
) : Serializable