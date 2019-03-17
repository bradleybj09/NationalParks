package com.example.nationalparks.model

import android.util.Log
import com.example.nationalparks.model.data.ParkDao
import com.example.nationalparks.model.data.SharedPreferencesDao
import com.example.nationalparks.model.data.WeatherDao
import com.example.nationalparks.model.room.DataWeather
import com.example.nationalparks.model.room.Park
import com.example.nationalparks.model.room.Weather
import com.example.nationalparks.retrofit.ApiInterface
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class ParkRepository @Inject constructor(
        private val sharedPreferencesDao: SharedPreferencesDao,
        private val apiInterface: ApiInterface,
        private val parkDao: ParkDao,
        private val weatherDao: WeatherDao
    ) {

    fun getParkList(): Observable<List<Park>> {
        Log.e("repository","getParkList")
        val observableFromApi = getParksFromApi()
        val observableFromDatabase = getParksFromDatabase()
        return Observable.concatArrayEager(observableFromApi, observableFromDatabase)
    }

    private fun getParksFromApi(): Observable<List<Park>> {
        Log.e("repository","getParksFromApi")
        return apiInterface.getParks()
            .doOnNext {
                Log.e("repository getParksFromApi", it.size.toString())
                for (item in it) {
                    Log.e("repository getParksFromApiEach",item.name)
                    parkDao.insertPark(item)
                }
            }
    }

    private fun getParksFromDatabase(): Observable<List<Park>> {
        Log.e("repository","getParksFromDatabase")
        return parkDao.getParks()
    }

    fun getParkByCode(parkCode: String): Observable<Park> {
        return parkDao.getParkByCode(parkCode)
    }

    fun getWeatherByParkCode(parkCode: String): Observable<List<DataWeather>> {
        val weatherFromApi = getWeatherFromApi(parkCode)
        val weatherFromDatabase = getWeatherFromDatabase(parkCode)
        return Observable.concatArrayEager(weatherFromApi, weatherFromDatabase)
    }

    private fun getWeatherFromApi(parkCode: String): Observable<List<DataWeather>> {
        apiInterface.getWeatherDumb(parkCode).enqueue(object : Callback<List<DataWeather>> {
            override fun onFailure(call: Call<List<DataWeather>>, t: Throwable) {
                Log.e("onfailure",call.request().toString())
            }

            override fun onResponse(call: Call<List<DataWeather>>, response: Response<List<DataWeather>>) {
                Log.e("onresponse body null",(response.body() == null).toString())
            }
        })
        return apiInterface.getWeatherByParkCode(parkCode)
            .doOnNext {
                weatherDao.insertWeather(it)
            }
    }

    private fun getWeatherFromDatabase(parkCode: String): Observable<List<DataWeather>> {
        return weatherDao.getWeatherByParkCode(parkCode)
    }

    fun getTemperaturePreference(): Boolean {
        return sharedPreferencesDao.getTemperaturePreference()
    }

    fun setTemperaturePreference(celcius: Boolean) {
        sharedPreferencesDao.setTemperaturePreference(celcius)
    }


//    init {
//        parks = getParkListFromDataSource()
//        //parks = listOf(TestData.park1, TestData.park2)
//    }

//    fun getParkListFromDataSource(): LiveData<List<Park>> {
//        var list: LiveData<List<Park>> = MutableLiveData()
//        apiInterface.getParks().enqueue(object : Callback<LiveData<List<Park>>> {
//            override fun onResponse(call: Call<LiveData<List<Park>>>, response: Response<LiveData<List<Park>>>) {
//                list = response.body()!!
//
//            }
//
//            override fun onFailure(call: Call<LiveData<List<Park>>>, t: Throwable) {
//                list = parkDao.getParks()
//            }
//        })
//        return list
//    }

//    fun getWeatherByParkCode(parkCode: String): LiveData<List<Weather>> {
//        var weather: LiveData<List<Weather>> = MutableLiveData()
//        apiInterface.getWeatherByParkCode(parkCode).enqueue(object : Callback<LiveData<List<Weather>>> {
//            override fun onResponse(call: Call<LiveData<List<Weather>>>, response: Response<LiveData<List<Weather>>>) {
//                weather = response.body()!!
//                weatherDao.insertWeather(weather.value!!)
//            }
//
//            override fun onFailure(call: Call<LiveData<List<Weather>>>, t: Throwable) {
//                weather = weatherDao.getWeatherByParkCode(parkCode)
//            }
//        })
//        return weather
////        val list: MutableList<Weather> = ArrayList()
////        for (weather in TestData.weatherArray) {
////            if (weather.parkCode == parkCode) {
////                list.add(weather)
////            }
////        }
////        return list
//    }

}