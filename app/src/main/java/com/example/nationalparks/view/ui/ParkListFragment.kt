package com.example.nationalparks.view.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.nationalparks.databinding.FragmentParkListBinding
import com.example.nationalparks.view.adapter.ParkListAdapter
import com.example.nationalparks.viewmodel.ParkListViewModel

class ParkListFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val viewModel = ViewModelProviders.of(this).get(ParkListViewModel::class.java)
        val adapter = ParkListAdapter(viewLifecycleOwner)
        adapter.replaceData(viewModel.parks)
        val binding = FragmentParkListBinding.inflate(inflater, container, false)
        binding.parkListRecyclerview.adapter = adapter
        return super.onCreateView(inflater, container, savedInstanceState)
    }

}