package com.example.nationalparks.view.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.nationalparks.databinding.FragmentParkDetailBinding
import com.example.nationalparks.viewmodel.ParkDetailViewModel
import com.example.nationalparks.viewmodel.ParkDetailViewModelFactory

class ParkDetailFragment : Fragment() {

    lateinit var viewModel: ParkDetailViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val args: ParkDetailFragmentArgs by navArgs()
        val parkId = args.parkId
        viewModel = ViewModelProviders.of(this, ParkDetailViewModelFactory(parkId)).get(ParkDetailViewModel::class.java)
        val binding = FragmentParkDetailBinding.inflate(inflater, container, false)
        binding.park = viewModel.park
        binding.viewModel = viewModel

        viewModel.showWeather.observe(this, Observer {
            it.getContentIfNotHandled()?.let {
                val weatherFragment = WeatherBottomDialogFragment()
                if (weatherFragment.arguments == null) {
                    weatherFragment.arguments = Bundle()
                }
                weatherFragment.arguments!!.putLong("parkId", parkId)
                weatherFragment.show(fragmentManager, "Tag")
            }
        })

        return binding.root
    }
}