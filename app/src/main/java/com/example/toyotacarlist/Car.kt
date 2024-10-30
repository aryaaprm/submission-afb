package com.example.toyotacarlist

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Car(
    val name: String,
    val engineCapacity: String,
    val fuelType: String,
    val totalSeat: String,
    val description: String,
    val photo: Int
): Parcelable
