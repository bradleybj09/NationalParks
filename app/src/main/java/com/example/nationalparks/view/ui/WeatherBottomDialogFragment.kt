package com.example.nationalparks.view.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nationalparks.R
import com.example.nationalparks.databinding.FragmentWeatherBottomSheetBinding
import com.example.nationalparks.view.adapter.WeatherAdapter
import com.example.nationalparks.viewmodel.WeatherViewModel
import com.example.nationalparks.viewmodel.WeatherViewModelFactory
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class WeatherBottomDialogFragment : BottomSheetDialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val parkId = arguments!!.getLong("parkId")
        val adapter = WeatherAdapter(viewLifecycleOwner)
        val viewModel = ViewModelProviders.of(this, WeatherViewModelFactory(parkId)).get(WeatherViewModel::class.java)
        val binding = FragmentWeatherBottomSheetBinding.inflate(inflater,container,false)
        binding.viewModel = viewModel
        binding.weatherRecyclerview.layoutManager = LinearLayoutManager(context)
        binding.weatherRecyclerview.adapter = adapter
        adapter.replaceData(viewModel.weather)
        return binding.root
    }
}