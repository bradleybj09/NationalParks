package com.example.nationalparks.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nationalparks.model.ParkRepository
import com.example.nationalparks.model.room.Park
import com.example.nationalparks.util.Event
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class ParkDetailViewModel @Inject constructor(val repository: ParkRepository) : ViewModel() {

    var parkResult: MutableLiveData<Park> = MutableLiveData()
    var parkError: MutableLiveData<String> = MutableLiveData()

    lateinit var disposableObserver: DisposableObserver<Park>

    fun parkResult(): LiveData<Park> {
        return parkResult
    }

    fun parkError(): LiveData<String> {
        return parkError
    }

    fun loadPark() {
        disposableObserver = object : DisposableObserver<Park>() {
            override fun onComplete() {

            }

            override fun onNext(t: Park) {
                parkResult.postValue(t)
            }

            override fun onError(e: Throwable) {
                parkError.postValue(e.message)
            }
        }

        repository.getParkByCode(parkCode)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
      //      .debounce(400, TimeUnit.MILLISECONDS)
            .subscribe(disposableObserver)
    }

    fun disposeElements() {
        if (!disposableObserver.isDisposed) disposableObserver.dispose()
    }

    lateinit var parkCode: String

    fun setup(parkCode: String) {
        this.parkCode = parkCode
    }

    private val _showWeather = MutableLiveData<Event<String>>()
    val showWeather: LiveData<Event<String>>
        get() = _showWeather

    fun showWeather() {
        _showWeather.value = Event(parkCode)
    }
}