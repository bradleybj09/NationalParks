package com.example.nationalparks.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.nationalparks.databinding.ListItemParkBinding
import com.example.nationalparks.model.room.Park
import com.example.nationalparks.view.ui.ParkListFragmentDirections

class ParkListAdapter(private var lifecycleOwner: LifecycleOwner) : RecyclerView.Adapter<ParkListAdapter.ParkViewHoldier>() {

    private var parks: List<Park> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParkViewHoldier {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ListItemParkBinding.inflate(layoutInflater, parent, false)
        binding.lifecycleOwner = lifecycleOwner
        return ParkViewHoldier(binding)
    }

    override fun onBindViewHolder(holder: ParkViewHoldier, position: Int) {
        holder.bind(parks[position], createOnClickListener(parks[position].parkId))
    }

    private fun createOnClickListener(parkId: Long): View.OnClickListener {
        return View.OnClickListener {
            ParkListFragmentDirections.actionParkListToParkDetail(parkId)
        }
    }

    fun replaceData(list: List<Park>) {
        this.parks = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return parks.size
    }

    class ParkViewHoldier(val binding: ListItemParkBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(park: Park, listener: View.OnClickListener) {
            binding.apply {
                this.park = park
                root.setOnClickListener(listener)
                executePendingBindings()
            }
        }
    }

}