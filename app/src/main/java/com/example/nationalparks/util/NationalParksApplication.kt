package com.example.nationalparks.util

import android.app.Activity
import android.app.Application
import androidx.fragment.app.Fragment
import com.example.nationalparks.dagger.AppModule
import com.example.nationalparks.dagger.DaggerAppComponent
import com.example.nationalparks.dagger.NetModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class NationalParksApplication: Application(), HasActivityInjector, HasSupportFragmentInjector {

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .netModule(NetModule("http://10.0.2.2:8080/m3-java-capstone/api/"))
            .build().inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector
    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentInjector
}