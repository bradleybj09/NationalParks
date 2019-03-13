package com.example.nationalparks.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nationalparks.model.ParkRepository
import com.example.nationalparks.model.room.Park
import com.example.nationalparks.util.Event

class ParkDetailViewModel(val parkCode: String) : ViewModel() {

    val park: Park
    val repository: ParkRepository

    init {
        repository = ParkRepository()
        park = repository.getParkByCode(parkCode)
    }


    private val _showWeather = MutableLiveData<Event<String>>()
    val showWeather: LiveData<Event<String>>
        get() = _showWeather

    fun showWeather() {
        _showWeather.value = Event(parkCode)
    }
}