package com.example.nationalparks.view.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nationalparks.databinding.FragmentParkListBinding
import com.example.nationalparks.model.room.Park
import com.example.nationalparks.retrofit.ApiInterface
import com.example.nationalparks.util.TestData
import com.example.nationalparks.view.adapter.ParkListAdapter
import com.example.nationalparks.viewmodel.ParkListViewModel
import com.example.nationalparks.viewmodel.ParkListViewModelFactory
import dagger.android.support.AndroidSupportInjection
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

class ParkListFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ParkListViewModelFactory
    lateinit var viewModel: ParkListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ParkListViewModel::class.java)
        val adapter = ParkListAdapter(viewLifecycleOwner)
        val binding = FragmentParkListBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.parkListRecyclerview.layoutManager = LinearLayoutManager(context)
        binding.parkListRecyclerview.adapter = adapter
        viewModel.loadParks()
        viewModel.parksResult().observe(this, Observer<List<Park>> {
            adapter.replaceData(it)
        })
        return binding.root
    }

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }
}