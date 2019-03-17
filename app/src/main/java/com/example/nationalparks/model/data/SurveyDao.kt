package com.example.nationalparks.model.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.nationalparks.model.room.Survey
import io.reactivex.Observable


@Dao
interface SurveyDao {

    @Query("SELECT * FROM survey")
    fun getSurveys(): Observable<List<Survey>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSurveys(surveys: List<Survey>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSurvey(survey: Survey)
}