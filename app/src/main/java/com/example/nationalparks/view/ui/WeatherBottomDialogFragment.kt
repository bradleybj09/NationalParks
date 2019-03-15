package com.example.nationalparks.view.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nationalparks.databinding.FragmentWeatherBottomSheetBinding
import com.example.nationalparks.view.adapter.WeatherAdapter
import com.example.nationalparks.viewmodel.WeatherViewModel
import com.example.nationalparks.viewmodel.WeatherViewModelFactory
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class WeatherBottomDialogFragment : BottomSheetDialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val parkCode = arguments!!.getString("parkCode")
        val adapter = WeatherAdapter(viewLifecycleOwner)
//        val viewModel = ViewModelProviders.of(this, WeatherViewModelFactory()).get(WeatherViewModel::class.java)
        val binding = FragmentWeatherBottomSheetBinding.inflate(inflater,container,false)
//        binding.viewModel = viewModel
//        binding.weatherRecyclerview.layoutManager = LinearLayoutManager(context)
//        binding.weatherRecyclerview.adapter = adapter
//        adapter.replaceData(viewModel.weather)
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