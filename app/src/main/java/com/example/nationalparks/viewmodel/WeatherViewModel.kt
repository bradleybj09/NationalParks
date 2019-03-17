package com.example.nationalparks.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nationalparks.model.ParkRepository
import com.example.nationalparks.model.room.DataWeather
import com.example.nationalparks.model.room.Weather
import com.example.nationalparks.util.Util
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class WeatherViewModel @Inject constructor(val repository: ParkRepository) : ViewModel() {

    var weatherResult: MutableLiveData<List<Weather>> = MutableLiveData()
    var weatherError: MutableLiveData<String> = MutableLiveData()

    lateinit var disposableObserver: DisposableObserver<List<DataWeather>>

    fun weatherResult(): LiveData<List<Weather>> {
        return weatherResult
    }

    fun weatherError(): LiveData<String> {
        return weatherError
    }

    fun loadWeather() {
        disposableObserver = object : DisposableObserver<List<DataWeather>>() {
            override fun onComplete() {

            }

            override fun onNext(t: List<DataWeather>) {
                weatherResult.postValue(Util.convert(t))
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
        if (weatherResult.value != null) {
            for (each in weatherResult.value!!) {
                each.updateTemps(celsius)
            }
        }
        repository.setTemperaturePreference(celsius)
    }
}