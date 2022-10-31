package com.mgchoi.WebDevCon.dao

import com.mgchoi.WebDevCon.vo.Parking
import org.springframework.stereotype.Repository

@Repository
interface ParkingMapper {

    fun insertParking(parking: Parking)
    fun selectParkings(): List<Parking>
    fun selectParkingById(parkingId: Int): Parking
    fun selectParkingsByMarket(marketId: Int): List<Parking>
    fun deleteParking(parkingId: Int)
    fun updateParking(parking: Parking)

}