package com.mgchoi.WebDevCon.service

import com.mgchoi.WebDevCon.vo.Parking

interface ParkingService {

    fun insertParking(parking: Parking)
    fun selectParkings(): List<Parking>
    fun selectParkingById(parkingId: Int): Parking
    fun selectParkingsByMarket(marketId: Int): List<Parking>
    fun deleteParking(parkingId: Int)
    fun updateParking(parking: Parking)

}