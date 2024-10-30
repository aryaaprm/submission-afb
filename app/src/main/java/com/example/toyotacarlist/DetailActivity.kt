package com.example.toyotacarlist

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        //toolbar setup
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar.setNavigationIcon(R.drawable.back_icon)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        //intent data
        val carImage = findViewById<ImageView>(R.id.car_image)
        val carName = findViewById<TextView>(R.id.car_name)
        val carEngineCapacity = findViewById<TextView>(R.id.engine_capacity)
        val carFuelType = findViewById<TextView>(R.id.fuel_type)
        val carTotalSeat = findViewById<TextView>(R.id.total_seat)
        val carDescription = findViewById<TextView>(R.id.car_description)
        val shareButton = findViewById<Button>(R.id.action_share)

        val imageResId = intent.getIntExtra("car_photo", 0)
        val name = intent.getStringExtra("car_name")
        val engineCapacity = intent.getStringExtra("car_enginecapacity")
        val fuelType = intent.getStringExtra("car_fueltype")
        val totalSeat = intent.getStringExtra("car_totalseat")
        val description = intent.getStringExtra("car_description")


        carImage.setImageResource(imageResId)
        carName.text = name
        carEngineCapacity.text = engineCapacity
        carFuelType.text = fuelType
        carTotalSeat.text = totalSeat
        carDescription.text = description

        //explicit intent
        shareButton.setOnClickListener {
            val shareText = """
                Toyota Showcase
                Nama: $name
                Kapasitas Mesin: $engineCapacity
                Bahan Bakar: $fuelType
                Jumlah Kursi: $totalSeat
                Deskripsi: $description
            """.trimIndent()

            val shareIntent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, shareText)
            }
            startActivity(Intent.createChooser(shareIntent, "Share via"))
        }
    }
}
