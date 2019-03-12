package com.example.nationalparks.viewmodel

import androidx.lifecycle.ViewModel
import com.example.nationalparks.model.ParkRepository
import com.example.nationalparks.model.room.Campground

class CampgroundListViewModel(parkId: Long) : ViewModel() {

    var campgrounds: List<Campground> = ArrayList()

    init {
        val repository = ParkRepository()
        campgrounds = repository.getCampgroundsByParkId(parkId)
    }
}