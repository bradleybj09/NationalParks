package com.example.nationalparks.dagger

import com.example.nationalparks.view.ui.MainActivity
import com.example.nationalparks.view.ui.ParkDetailFragment
import com.example.nationalparks.view.ui.ParkListFragment
import com.example.nationalparks.view.ui.WeatherBottomDialogFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun contributeParkListFragment(): ParkListFragment

    @ContributesAndroidInjector
    abstract fun contributeParkDetailFragment(): ParkDetailFragment

    @ContributesAndroidInjector
    abstract fun contributeWeatherFragment(): WeatherBottomDialogFragment
}