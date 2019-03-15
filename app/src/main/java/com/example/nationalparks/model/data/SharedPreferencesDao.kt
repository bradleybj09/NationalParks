package com.example.nationalparks.model.data

import com.example.nationalparks.util.MySharedPreferences

class SharedPreferencesDao(val mySharedPreferences: MySharedPreferences) {

    fun getTemperaturePreference(): Boolean {
        return mySharedPreferences.getBoolean("temperature")
    }

    fun setTemperaturePreference(celcius: Boolean) {
        mySharedPreferences.putBoolean("temperature", celcius)
    }
}