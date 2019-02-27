package com.example.nationalparks.dagger

import android.app.Application
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, AppModule::class, BuildersModule::class])
interface AppComponent {

    fun inject(application: Application)
}