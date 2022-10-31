package com.mgchoi.WebDevCon.dao

import com.mgchoi.WebDevCon.vo.Market
import org.springframework.stereotype.Repository
import org.yaml.snakeyaml.error.Mark

@Repository
interface MarketMapper {

    fun insertMarket(market: Market)
    fun selectMarkets(): List<Market>
    fun selectMarketById(marketId: Int): Market
    fun deleteMarket(marketId: Int)
    fun updateMarket(market: Market)

}