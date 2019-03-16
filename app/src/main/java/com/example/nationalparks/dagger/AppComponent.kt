package com.example.nationalparks.dagger

import com.example.nationalparks.util.NationalParksApplication
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, BuildersModule::class, AppModule::class, NetModule::class])
interface AppComponent {

    fun inject(application: NationalParksApplication)
}