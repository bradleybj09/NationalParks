package com.example.nationalparks.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nationalparks.model.ParkRepository
import com.example.nationalparks.model.room.Park

class ParkListViewModel : ViewModel() {

    private val parks = MutableLiveData<List<Park>>()

    init {
        val respository = ParkRepository()
        parks.value = respository.getParks()
    }

}