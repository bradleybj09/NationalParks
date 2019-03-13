package com.example.nationalparks.util

data class Weather(val parkCode: String, val day: Int, val low: Int, val high: Int, val forecast: String) {

    var recommendation: String
    val imageName: String

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
        imageName = when (forecast) {
            "partly cloudy" -> "partlycloudy"
            else -> forecast
        }
    }

}