package com.example.nationalparks.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.nationalparks.databinding.ListItemCampgroundBinding
import com.example.nationalparks.model.room.Campground

class CampgroundListAdapter(private var campgrounds: List<Campground>,
                            private var listener: OnItemClickListener,
                            private val lifecycleOwner: LifecycleOwner) : RecyclerView.Adapter<CampgroundListAdapter.CampgroundViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CampgroundViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ListItemCampgroundBinding.inflate(layoutInflater, parent, false)
        binding.lifecycleOwner = lifecycleOwner
        return CampgroundViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CampgroundViewHolder, position: Int) {
        holder.bind(campgrounds[position], listener)
    }

    override fun getItemCount(): Int {
        return campgrounds.size
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    class CampgroundViewHolder(var binding: ListItemCampgroundBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(campground: Campground, listener: OnItemClickListener) {
            binding.campground = campground
            binding.root.setOnClickListener { listener.onItemClick(layoutPosition) }
            binding.executePendingBindings()
        }
    }
}