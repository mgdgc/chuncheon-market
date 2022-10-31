package com.mgchoi.WebDevCon.service

import com.mgchoi.WebDevCon.dao.MarketMapper
import com.mgchoi.WebDevCon.vo.Market
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MarketServiceImpl : MarketService {

    @Autowired
    private lateinit var mapper: MarketMapper

    override fun insertMarket(market: Market) {
        mapper.insertMarket(market)
    }

    override fun selectMarkets(): List<Market> {
        return mapper.selectMarkets()
    }

    override fun selectMarketById(marketId: Int): Market {
        return mapper.selectMarketById(marketId)
    }

    override fun deleteMarket(marketId: Int) {
        mapper.deleteMarket(marketId)
    }

    override fun updateMarket(market: Market) {
        mapper.updateMarket(market)
    }
}