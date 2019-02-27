package com.example.nationalparks.view.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.nationalparks.R
import com.example.nationalparks.viewmodel.ParksViewModel
import dagger.android.AndroidInjection

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: ParksViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this).get(ParksViewModel::class.java)
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
}
