package com.mgchoi.WebDevCon.service

import com.mgchoi.WebDevCon.vo.Market

interface MarketService {

    fun insertMarket(market: Market)
    fun selectMarkets(): List<Market>
    fun selectMarketById(marketId: Int): Market
    fun deleteMarket(marketId: Int)
    fun updateMarket(market: Market)

}