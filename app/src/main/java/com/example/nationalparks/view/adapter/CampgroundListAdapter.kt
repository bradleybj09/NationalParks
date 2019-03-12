package com.example.nationalparks.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.nationalparks.databinding.ListItemCampgroundBinding
import com.example.nationalparks.model.room.Campground
import com.example.nationalparks.view.ui.CampgroundListFragmentDirections

class CampgroundListAdapter(private val lifecycleOwner: LifecycleOwner) : RecyclerView.Adapter<CampgroundListAdapter.CampgroundViewHolder>() {

    private var campgrounds: List<Campground> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CampgroundViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ListItemCampgroundBinding.inflate(layoutInflater, parent, false)
        binding.lifecycleOwner = lifecycleOwner
        return CampgroundViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CampgroundViewHolder, position: Int) {
        holder.bind(campgrounds[position], createOnClickListener(campgrounds[position].campgroundId))
    }

    override fun getItemCount(): Int {
        return campgrounds.size
    }

    fun createOnClickListener(campgroundId: Long): View.OnClickListener {
        return View.OnClickListener {
            val direction = CampgroundListFragmentDirections.actionCampgroundListToReservation(campgroundId)
            it.findNavController().navigate(direction)
        }
    }

    fun replaceData(list: List<Campground>) {
        campgrounds = list
        notifyDataSetChanged()
    }

    class CampgroundViewHolder(var binding: ListItemCampgroundBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(campground: Campground, listener: View.OnClickListener) {
            binding.apply {
                this.campground = campground
                root.setOnClickListener(listener)
                executePendingBindings()
            }
        }
    }
}