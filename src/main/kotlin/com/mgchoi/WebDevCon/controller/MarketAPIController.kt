package com.mgchoi.WebDevCon.controller

import com.mgchoi.WebDevCon.service.MarketService
import com.mgchoi.WebDevCon.vo.Market
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MarketAPIController {

    @Autowired
    private lateinit var marketService: MarketService

    @GetMapping("/api/market")
    public fun getMarkets(): List<Market> {
        return marketService.selectMarkets()
    }

}