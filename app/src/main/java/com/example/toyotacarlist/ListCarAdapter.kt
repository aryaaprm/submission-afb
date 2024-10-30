package com.example.toyotacarlist

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListCarAdapter(private val listCar: ArrayList<Car>) : RecyclerView.Adapter<ListCarAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_car, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val car = listCar[position]

        holder.imgCar.setImageResource(car.photo)
        holder.tvCarName.text = car.name
        holder.tvEngineCapacity.text = car.engineCapacity
        holder.tvFuelType.text = car.fuelType

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java).apply {
                putExtra("car_photo", car.photo)
                putExtra("car_name", car.name)
                putExtra("car_enginecapacity", car.engineCapacity)
                putExtra("car_fueltype", car.fuelType)
                putExtra("car_totalseat", car.totalSeat)
                putExtra("car_description", car.description)
            }
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = listCar.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgCar: ImageView = itemView.findViewById(R.id.car_image)
        val tvCarName: TextView = itemView.findViewById(R.id.car_name)
        val tvEngineCapacity: TextView = itemView.findViewById(R.id.engine_capacity)
        val tvFuelType: TextView = itemView.findViewById(R.id.fuel_type)
    }
}
