package com.example.nationalparks.model.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Entity
import java.io.Serializable
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.roundToInt

@Entity(
    tableName = "weather"
)
data class Weather(
    val parkCode: String,
    val day: Int,
    val low: Int,
    val high: Int,
    val forecast: String) : Serializable {

    var recommendation: String
    val imagePath: String
    val dayString: String
    val forecastString: String
    val lowString = MutableLiveData<String>()
    val highString= MutableLiveData<String>()
    init {
        lowString.value = low.toString()
        highString.value = high.toString()
        recommendation = when (forecast) {
            "sunny" -> "Don't forget your sunblock."
            "partly cloudy" -> ""
            "cloudy" -> ""
            "rain" -> "Remember to bring rain gear and waterproof shoes."
            "thunderstorms" -> "Find shelter and avoid hiking on exposed ridges."
            "snow" -> "You'll want snowshoes."
            else -> "Prepare for Hellfire, I guess?"
        }
        if (high > 75) {
            if (recommendation.isNotBlank()) {
               recommendation += "\n"
            }
            recommendation += "We suggest that you bring an extra gallon of water!"
        }
        if (high - low > 20) {
            if (recommendation.isNotBlank()) {
                recommendation += "\n"
            }
            recommendation += "\nWear breathable layers!"
        }
        if (low < 20) {
            if (recommendation.isNotBlank()) {
                recommendation += "\n"
            }
            recommendation += "Be careful not to get frostbitten!"
        }

        imagePath = when (forecast) {
            "partly cloudy" -> "partlycloudy"
            else -> forecast
        }

        forecastString = when (forecast) {
            "partly cloudy" -> "Partly\nCloudy"
            else -> forecast.capitalize()
        }

        val cal = GregorianCalendar()
        val dateFormat = SimpleDateFormat("EEEE", Locale.US)
        dayString = when (day) {
            1 -> "Today"
            2 -> "Tomorrow"
            else -> dateFormat.format(cal.apply {
                add(Calendar.DATE, day-1)
            }.time)
        }
    }

    fun updateTemps(celsius: Boolean) {
        if (celsius) {
            lowString.value = ((low - 32) / 1.8).roundToInt().toString()
            highString.value = ((high - 32) / 1.8).roundToInt().toString()
        } else {
            lowString.value = low.toString()
            highString.value = high.toString()
        }
    }
}