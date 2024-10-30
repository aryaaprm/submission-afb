package com.example.toyotacarlist

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {
    private lateinit var rvCars: RecyclerView
    private val list = ArrayList<Car>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //toolbar setup
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        rvCars = findViewById(R.id.rv_cars)
        rvCars.setHasFixedSize(true)
        list.addAll(getListCars())
        showRecyclerList()
    }

    private fun getListCars(): ArrayList<Car> {
        val dataName = resources.getStringArray(R.array.car_name)
        val dataEngineCapacity = resources.getStringArray(R.array.car_enginecapacity)
        val dataFuelType = resources.getStringArray(R.array.car_fueltype)
        val dataTotalSeat = resources.getStringArray(R.array.car_totalseat)
        val dataDescription = resources.getStringArray(R.array.car_description)
        val dataPhoto = resources.obtainTypedArray(R.array.car_photo)

        val listCar = ArrayList<Car>()
        for (i in dataName.indices) {
            val car = Car(
                name = dataName[i],
                engineCapacity = dataEngineCapacity[i],
                fuelType = dataFuelType[i],
                totalSeat = dataTotalSeat[i],
                description = dataDescription[i],
                photo = dataPhoto.getResourceId(i, -1)
            )
            listCar.add(car)
        }
        return listCar
    }

    private fun showRecyclerList() {
        rvCars.layoutManager = LinearLayoutManager(this)
        val listCarAdapter = ListCarAdapter(list)
        rvCars.adapter = listCarAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    //about intent
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intent = Intent(this, AboutActivity::class.java)
        startActivity(intent)
        return true
    }
}
