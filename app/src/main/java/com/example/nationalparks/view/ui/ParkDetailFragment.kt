package com.example.nationalparks.view.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.navArgs
import com.example.nationalparks.databinding.FragmentParkDetailBinding
import com.example.nationalparks.model.room.Park
import com.example.nationalparks.viewmodel.ParkDetailViewModel
import com.example.nationalparks.viewmodel.ParkDetailViewModelFactory
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class ParkDetailFragment : Fragment() {

    @Inject
    lateinit var detailViewModelFactory: ParkDetailViewModelFactory
    lateinit var detailViewModel: ParkDetailViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        AndroidSupportInjection.inject(this)
        val args: ParkDetailFragmentArgs by navArgs()
        val parkCode = args.parkCode
        detailViewModel = ViewModelProviders.of(this, detailViewModelFactory).get(ParkDetailViewModel::class.java)
        detailViewModel.setup(parkCode)
        val binding = FragmentParkDetailBinding.inflate(inflater, container, false)
        detailViewModel.loadPark()
        detailViewModel.parkResult.observe(this, Observer<Park> {
            binding.park = it
        })
        binding.viewModel = detailViewModel
        detailViewModel.showWeather.observe(this, Observer {
            it.getContentIfNotHandled()?.let {
                val weatherFragment = WeatherBottomDialogFragment()
                if (weatherFragment.arguments == null) {
                    weatherFragment.arguments = Bundle()
                }
                weatherFragment.arguments!!.putString("parkCode", parkCode)
                weatherFragment.show(fragmentManager, "Tag")
            }
        })

        return binding.root
    }
}