package com.example.nationalparks.view.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.nationalparks.R
import com.example.nationalparks.viewmodel.ParksViewModel
import dagger.android.AndroidInjection

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: ParksViewModel
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(ParksViewModel::class.java)
        AndroidInjection.inject(this)
        navController = Navigation.findNavController(this, R.id.parks_nav_fragment)

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }


}
