package com.example.nationalparks.model

import com.example.nationalparks.model.room.Park
import java.time.LocalDate

class ParkRepository {

    var parks: List<Park> = ArrayList()

    init {
        parks = listOf(
            Park(1, "Test Park 1", "Test Location 1", LocalDate.of(2001,1,1), 1000, 50, "Test Description 1"),
            Park(2, "Test Park 2", "Test Location 2", LocalDate.of(2002,2,2), 2000, 100, "Test Description 2")
        )
    }

    fun getParkById(parkId: Long): Park {
        for (park in parks) {
            if (park.parkId == parkId) {
                return park
            }
        }
        return Park(-1,"","", LocalDate.now(),0,0,"")
    }
}