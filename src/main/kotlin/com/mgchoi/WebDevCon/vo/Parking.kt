package com.mgchoi.WebDevCon.vo

data class Parking(
    val parkingId: Int,
    var marketId: Int,
    var parkingName: String,
    var longitude: Double,
    var latitude: Double,
    var capacity: Int
)