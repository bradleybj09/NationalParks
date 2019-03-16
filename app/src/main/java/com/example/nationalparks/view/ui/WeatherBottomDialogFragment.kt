package com.example.nationalparks.view.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nationalparks.databinding.FragmentWeatherBottomSheetBinding
import com.example.nationalparks.model.room.Weather
import com.example.nationalparks.view.adapter.WeatherAdapter
import com.example.nationalparks.viewmodel.WeatherViewModel
import com.example.nationalparks.viewmodel.WeatherViewModelFactory
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class WeatherBottomDialogFragment : BottomSheetDialogFragment() {

    @Inject
    lateinit var weatherViewModelFactory: WeatherViewModelFactory
    lateinit var weatherViewModel: WeatherViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        AndroidSupportInjection.inject(this)
        val parkCode = arguments!!.getString("parkCode")
        Log.e("parkCode",parkCode)
        val adapter = WeatherAdapter(viewLifecycleOwner)
        weatherViewModel = ViewModelProviders.of(this, weatherViewModelFactory).get(WeatherViewModel::class.java)
        weatherViewModel.setup(parkCode)
        val binding = FragmentWeatherBottomSheetBinding.inflate(inflater,container,false)
        binding.viewModel = weatherViewModel
        binding.weatherRecyclerview.layoutManager = LinearLayoutManager(context)
        binding.weatherRecyclerview.adapter = adapter
        weatherViewModel.loadWeather()
        weatherViewModel.weatherResult.observe(this, Observer<List<Weather>> {
            weatherViewModel.updateWeather()
            adapter.replaceData(it)
        })
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.viewTreeObserver.addOnGlobalLayoutListener {
            val d = dialog as BottomSheetDialog
            val bottomSheet = d.findViewById<FrameLayout>(com.google.android.material.R.id.design_bottom_sheet)
            val behavior = BottomSheetBehavior.from(bottomSheet).apply {
                state = BottomSheetBehavior.STATE_EXPANDED
                peekHeight = 0;
            }
        }
    }
}