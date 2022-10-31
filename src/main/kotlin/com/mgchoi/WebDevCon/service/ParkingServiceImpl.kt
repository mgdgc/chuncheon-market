package com.mgchoi.WebDevCon.service

import com.mgchoi.WebDevCon.dao.ParkingMapper
import com.mgchoi.WebDevCon.vo.Parking
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ParkingServiceImpl : ParkingService {

    @Autowired
    private lateinit var mapper: ParkingMapper

    override fun insertParking(parking: Parking) {
        mapper.insertParking(parking)
    }

    override fun selectParkings(): List<Parking> {
        return mapper.selectParkings()
    }

    override fun selectParkingById(parkingId: Int): Parking {
        return mapper.selectParkingById(parkingId)
    }

    override fun selectParkingsByMarket(marketId: Int): List<Parking> {
        return mapper.selectParkingsByMarket(marketId)
    }

    override fun deleteParking(parkingId: Int) {
        mapper.deleteParking(parkingId)
    }

    override fun updateParking(parking: Parking) {
        mapper.updateParking(parking)
    }
}