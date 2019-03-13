package com.example.nationalparks.util

import java.text.SimpleDateFormat
import java.util.*

data class Weather(val parkCode: String, val day: Int, val low: Int, val high: Int, val forecast: String) {

    var recommendation: String
    val imagePath: String
    val dayString: String
    init {
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
            else -> "$forecast"
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

}