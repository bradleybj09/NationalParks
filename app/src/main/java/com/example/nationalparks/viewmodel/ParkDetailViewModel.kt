package com.example.nationalparks.viewmodel

import androidx.lifecycle.ViewModel
import com.example.nationalparks.model.ParkRepository
import com.example.nationalparks.model.room.Park

class ParkDetailViewModel(val parkId: Long) : ViewModel() {

    val park: Park

    init {
        val repository = ParkRepository()
        park = repository.getParkById(parkId)
    }
}