package com.example.nationalparks.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nationalparks.model.ParkRepository
import com.example.nationalparks.model.room.Park
import com.example.nationalparks.model.room.Weather
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class WeatherViewModel @Inject constructor(val repository: ParkRepository) : ViewModel() {

    var weatherResult: MutableLiveData<List<Weather>> = MutableLiveData()
    var weatherError: MutableLiveData<String> = MutableLiveData()

    lateinit var disposableObserver: DisposableObserver<List<Weather>>

    fun weatherResult(): LiveData<List<Weather>> {
        return weatherResult
    }

    fun weatherError(): LiveData<String> {
        return weatherError
    }

    fun loadWeather() {
        disposableObserver = object : DisposableObserver<List<Weather>>() {
            override fun onComplete() {

            }

            override fun onNext(t: List<Weather>) {
                weatherResult.postValue(t)
            }

            override fun onError(e: Throwable) {
                weatherError.postValue(e.message)
            }
        }

        repository.getWeatherByParkCode(parkCode)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
  //          .debounce(400, TimeUnit.MILLISECONDS)
            .subscribe(disposableObserver)
    }

    fun disposeElements() {
        if (!disposableObserver.isDisposed) disposableObserver.dispose()
    }

    lateinit var parkCode: String
    var celsius = false

    fun setup(parkCode: String) {
        this.parkCode = parkCode
        celsius = repository.getTemperaturePreference()
    }

    fun updateWeather() {
        for (each in weatherResult.value!!) {
            each.updateTemps(celsius)
        }
    }
}