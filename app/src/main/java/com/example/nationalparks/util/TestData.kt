package com.example.nationalparks.util

import com.example.nationalparks.model.room.Park
import com.example.nationalparks.model.room.Weather

class TestData {

    companion object {
        val park1 = Park(
            "GNP",
            "Glacier National Park",
            "Montana",
            1013322,
            6646,
            745.6,
            923,
            "Temperate",
            1910,
            2338528,
            "Far away in northwestern Montana, hidden from view by clustering mountain peaks, lies an unmapped corner—the Crown of the Continent.",
            "George Bird Grinnell",
            "Glacier might very well be the most beautiful of America's national parks. John Muir called it 'the best care-killing scenery on the continent.' The mountains are steep, snowcapped, and punctuated by stunning mountain lakes and creeks. Much of the land remains wild and pristine, a result of its remote location and the lack of visitation in the 19th century.",
            12,
            300
        )

        val park2 = Park(
            "CVNP",
            "Cuyahoga Valley National Park",
            "Ohio",
            32832,
            696,
            125.0,
            0,
            "Woodland",
            2000,
            2189849,
            "Of all the paths you take in life, make sure a few of them are dirt.",
            "John Muir",
            "Though a short distance from the urban areas of Cleveland and Akron, Cuyahoga Valley National Park seems worlds away. The park is a refuge for native plants and wildlife, and provides routes of discovery for visitors. The winding Cuyahoga River gives way to deep forests, rolling hills, and open farmlands. Walk or ride the Towpath Trail to follow the historic route of the Ohio & Erie Canal",
            0,
            390
        )
        val weatherArray = listOf(
            Weather("GNP", 1, 27, 40, "snow"),
            Weather("GNP", 2, 31, 43, "snow"),
            Weather("GNP", 3, 28, 40, "partly cloudy"),
            Weather("GNP", 4, 24, 34, "cloudy"),
            Weather("GNP", 5, 25, 32, "snow"),
            Weather("CVNP", 1, 38, 62, "rain"),
            Weather("CVNP", 2, 38, 56, "partly cloudy"),
            Weather("CVNP", 3, 51, 66, "partly cloudy"),
            Weather("CVNP", 4, 55, 65, "rain"),
            Weather("CVNP", 5, 53, 69, "thunderstorms")
        )
    }
}