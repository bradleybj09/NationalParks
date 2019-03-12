package com.example.nationalparks.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nationalparks.model.ParkRepository
import com.example.nationalparks.model.room.Park
import com.example.nationalparks.util.Event

class ParkDetailViewModel(val parkId: Long) : ViewModel() {

    val park: Park
    val repository: ParkRepository

    init {
        repository = ParkRepository()
        park = repository.getParkById(parkId)
    }


    private val _showWeather = MutableLiveData<Event<Long>>()
    val showWeather: LiveData<Event<Long>>
        get() = _showWeather

    fun showWeather() {
        _showWeather.value = Event(parkId)
    }
}