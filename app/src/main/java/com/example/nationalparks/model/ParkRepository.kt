package com.example.nationalparks.model

import com.example.nationalparks.model.data.SharedPreferencesDao
import com.example.nationalparks.model.room.Park
import com.example.nationalparks.util.TestData
import com.example.nationalparks.model.room.Weather
import javax.inject.Inject

class ParkRepository @Inject constructor(val sharedPreferencesDao: SharedPreferencesDao){

    val parks: List<Park>

    init {
        //parks = parkDao.getParks()
        parks = listOf(TestData.park1, TestData.park2)
    }

    fun getParkByCode(parkCode: String): Park {
        for (park in parks) {
            if (park.parkCode == parkCode) {
                return park
            }
        }
        return Park("error","error","error",0,0,0.0,0,"error",0,0,"error","error", "error",0,0)
    }

    fun getWeatherByParkCode(parkCode: String): List<Weather> {
        //return weatherDao.getWeatherByParkCode(parkCode)
        val list: MutableList<Weather> = ArrayList()
        for (weather in TestData.weatherArray) {
            if (weather.parkCode == parkCode) {
                list.add(weather)
            }
        }
        return list
    }

    fun getTemperaturePreference(): Boolean {
        return sharedPreferencesDao.getTemperaturePreference()
    }

    fun setTemperaturePreference(celcius: Boolean) {
        sharedPreferencesDao.setTemperaturePreference(celcius)
    }
}