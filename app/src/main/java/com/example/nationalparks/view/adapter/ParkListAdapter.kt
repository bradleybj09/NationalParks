package com.example.nationalparks.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.nationalparks.databinding.ListItemParkBinding
import com.example.nationalparks.model.room.Park
import com.example.nationalparks.view.ui.ParkListFragmentDirections

class ParkListAdapter(private val lifecycleOwner: LifecycleOwner) : RecyclerView.Adapter<ParkListAdapter.ParkViewHolder>() {

    private var parks: List<Park> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParkViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ListItemParkBinding.inflate(layoutInflater, parent, false)
        binding.lifecycleOwner = lifecycleOwner
        return ParkViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ParkViewHolder, position: Int) {
        holder.bind(parks[position], createOnClickListener(parks[position].parkId))
    }

    private fun createOnClickListener(parkId: Long): View.OnClickListener {
        return View.OnClickListener {
            val direction = ParkListFragmentDirections.actionParkListToParkDetail(parkId)
            it.findNavController().navigate(direction)
        }
    }

    fun replaceData(list: List<Park>) {
        parks = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return parks.size
    }

    class ParkViewHolder(val binding: ListItemParkBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(park: Park, listener: View.OnClickListener) {
            binding.apply {
                this.park = park
                root.setOnClickListener(listener)
                executePendingBindings()
            }
        }
    }
}