package com.example.nationalparks.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.nationalparks.databinding.ListItemWeatherBinding
import com.example.nationalparks.util.Weather

class WeatherAdapter(private val lifecycleOwner: LifecycleOwner) : RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {

    private var weather: List<Weather> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ListItemWeatherBinding.inflate(layoutInflater, parent, false)
        binding.lifecycleOwner = lifecycleOwner
        return WeatherViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.bind(weather[position])
    }


    override fun getItemCount(): Int {
        return weather.size
    }

    fun replaceData(list: List<Weather>) {
        weather = list
        notifyDataSetChanged()
    }

    class WeatherViewHolder(val binding: ListItemWeatherBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(weather: Weather) {
            binding.apply {
                this.weather = weather
                executePendingBindings()
            }
        }
    }
}