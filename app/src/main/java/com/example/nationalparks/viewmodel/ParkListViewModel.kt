package com.example.nationalparks.viewmodel

import androidx.lifecycle.ViewModel
import com.example.nationalparks.model.ParkRepository
import javax.inject.Inject

class ParkListViewModel @Inject constructor(repository: ParkRepository) : ViewModel() {

    val parks = repository.parks
}