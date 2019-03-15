package com.example.nationalparks.dagger

import android.app.Application
import com.example.nationalparks.util.NationalParksApplication
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, BuildersModule::class, AppModule::class])
interface AppComponent {

    fun inject(application: NationalParksApplication)
}