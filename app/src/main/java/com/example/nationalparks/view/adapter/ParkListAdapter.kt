package com.example.nationalparks.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.nationalparks.databinding.ListItemParkBinding
import com.example.nationalparks.model.room.Park

class ParkListAdapter(private var parks: List<Park>,
                      private var listener: OnItemClickListener,
                      private var lifecycleOwner: LifecycleOwner) : RecyclerView.Adapter<ParkListAdapter.ParkViewHoldier>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParkViewHoldier {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ListItemParkBinding.inflate(layoutInflater, parent, false)
        binding.lifecycleOwner = lifecycleOwner
        return ParkViewHoldier(binding)
    }

    override fun onBindViewHolder(holder: ParkViewHoldier, position: Int) {
        holder.bind(parks[position], listener)
    }

    override fun getItemCount(): Int {
        return parks.size
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    class ParkViewHoldier(var binding: ListItemParkBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(park: Park, listener: OnItemClickListener) {
            binding.park = park
            binding.root.setOnClickListener { listener.onItemClick(layoutPosition) }
            binding.executePendingBindings()
        }
    }

}