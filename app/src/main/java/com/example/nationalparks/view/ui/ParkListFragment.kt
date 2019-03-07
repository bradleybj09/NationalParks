package com.example.nationalparks.view.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nationalparks.databinding.FragmentParkListBinding
import com.example.nationalparks.view.adapter.ParkListAdapter
import com.example.nationalparks.viewmodel.ParkListViewModel

class ParkListFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val viewModel = ViewModelProviders.of(this).get(ParkListViewModel::class.java)
        val adapter = ParkListAdapter(viewLifecycleOwner)
        val binding = FragmentParkListBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.parkListRecyclerview.layoutManager = LinearLayoutManager(context)
        binding.parkListRecyclerview.adapter = adapter
        adapter.replaceData(viewModel.parks)
        return binding.root
    }
}