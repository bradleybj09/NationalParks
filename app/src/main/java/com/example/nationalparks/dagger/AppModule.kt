package com.example.nationalparks.dagger

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.ViewModelProvider
import androidx.room.Database
import androidx.room.Room
import com.example.nationalparks.model.data.ParkDao
import com.example.nationalparks.model.data.SharedPreferencesDao
import com.example.nationalparks.model.data.WeatherDao
import com.example.nationalparks.model.room.ParksDatabase
import com.example.nationalparks.util.MySharedPreferences
import com.example.nationalparks.viewmodel.ParkDetailViewModelFactory
import com.example.nationalparks.viewmodel.ParkListViewModelFactory
import com.example.nationalparks.viewmodel.WeatherViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val application: Application) {

    @Provides
    @Singleton
    fun provideApplication(): Application = application

    @Provides
    @Singleton
    fun provideSharedPreferences(application: Application): SharedPreferences
            = application.applicationContext.getSharedPreferences("temperaturePreferences", Context.MODE_PRIVATE)

    @Provides
    @Singleton
    fun provideParksDatabase(app: Application): ParksDatabase =
        Room.databaseBuilder(app, ParksDatabase::class.java, "npgeek_db").build()

    @Provides
    @Singleton
    fun provideParkDao(database: ParksDatabase): ParkDao = database.parkDao()

    @Provides
    @Singleton
    fun provideWeatherDao(database: ParksDatabase): WeatherDao = database.weatherDao()

    @Provides
    @Singleton
    fun provideSharedPreferencesDao(mySharedPreferences: MySharedPreferences): SharedPreferencesDao = SharedPreferencesDao(mySharedPreferences)

    @Provides
    @Singleton
    fun provideMySharedPreferences(sharedPreferences: SharedPreferences): MySharedPreferences = MySharedPreferences(sharedPreferences)

    @Provides
    fun provideParkListViewModelFactory(factory: ParkListViewModelFactory): ViewModelProvider.Factory = factory

    @Provides
    fun provideParkDetailViewModelFactory(factory: ParkDetailViewModelFactory): ViewModelProvider.Factory = factory

    @Provides
    fun provideWeatherViewModelFactory(factory: WeatherViewModelFactory): ViewModelProvider.Factory = factory
}