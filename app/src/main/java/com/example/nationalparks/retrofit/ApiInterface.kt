package com.example.nationalparks.retrofit

import com.example.nationalparks.model.room.DataWeather
import com.example.nationalparks.model.room.Park
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("parks")
    fun getParks(): Observable<List<Park>>

    @GET("weather")
    fun getWeatherDumb(@Query("parkCode") parkCode: String): Call<List<DataWeather>>

    @GET("weather")
    fun getWeatherByParkCode(@Query("parkCode") parkCode: String): Observable<List<DataWeather>>

//    @GET("survey")
//    fun getSurveyResults(): Observable<List<Survey>>

//    @POST("survey")
//    fun postSurveyResponse()
}