package com.mgchoi.WebDevCon.controller

import com.mgchoi.WebDevCon.service.MarketService
import com.mgchoi.WebDevCon.vo.Market
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.util.Locale
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@RestController
class MarketAPIController {

    @Autowired
    private lateinit var marketService: MarketService

    @GetMapping("/api/market")
    public fun getMarkets(): List<Market> {
        return marketService.selectMarkets()
    }

    @GetMapping("/market/{marketId}")
    public fun getMarket(
        locale: Locale, request: HttpServletRequest, response: HttpServletResponse,
        @PathVariable("marketId") marketId: Int
    ): Market {
        return marketService.selectMarketById(marketId)
    }

}