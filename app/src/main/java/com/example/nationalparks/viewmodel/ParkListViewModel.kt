package com.example.nationalparks.viewmodel

import androidx.lifecycle.ViewModel
import com.example.nationalparks.model.ParkRepository
import com.example.nationalparks.model.room.Park

class ParkListViewModel : ViewModel() {

    var parks: List<Park> = ArrayList()

    init {
        val repository = ParkRepository()
        parks = repository.getParks()
    }

}