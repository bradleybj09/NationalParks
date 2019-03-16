package com.example.nationalparks.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nationalparks.model.ParkRepository
import com.example.nationalparks.model.room.Park
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class ParkListViewModel @Inject constructor(private val repository: ParkRepository) : ViewModel() {

    var parksResult: MutableLiveData<List<Park>> = MutableLiveData()
    var parksError: MutableLiveData<String> = MutableLiveData()

    lateinit var disposableObserver: DisposableObserver<List<Park>>

    fun parksResult(): LiveData<List<Park>> {
        return parksResult
    }

    fun parksError(): LiveData<String> {
        return parksError
    }

    fun loadParks() {
        disposableObserver = object : DisposableObserver<List<Park>>(){

            override fun onComplete() {

            }

            override fun onNext(t: List<Park>) {
                parksResult.postValue(t)
            }

            override fun onError(e: Throwable) {
                parksError.postValue(e?.message)
            }
        }

        repository.getParkList()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
  //          .debounce(400, TimeUnit.MILLISECONDS)
            .subscribe(disposableObserver)
    }

    fun disposeElements() {
        if (!disposableObserver.isDisposed) disposableObserver.dispose()
    }
}