package com.mgchoi.WebDevCon.vo

import lombok.Getter
import lombok.Setter

@Getter
@Setter
data class Market(
    val marketId: Int,
    var marketName: String,
    var marketDesc: String,
    var longitude: Double,
    var latitude: Double,
    var openTime: String?,
    var closeTime: String?,
    var openDay: String?,
    var fileId: Int?
)
