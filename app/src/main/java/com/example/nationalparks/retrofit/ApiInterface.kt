package com.example.nationalparks.retrofit

import androidx.lifecycle.LiveData
import com.example.nationalparks.model.room.Park
import com.example.nationalparks.model.room.Survey
import com.example.nationalparks.model.room.Weather
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiInterface {

    @GET("parks/")
    fun getParks(): Observable<List<Park>>

    @GET("weather")
    fun getWeatherDumb(@Query("parkCode") parkCode: String): Call<List<Weather>>

    @GET("weather")
    fun getWeatherByParkCode(@Query("parkCode") parkCode: String): Observable<List<Weather>>

//    @GET("survey")
//    fun getSurveyResults(): Observable<List<Survey>>

//    @POST("survey")
//    fun postSurveyResponse()
}