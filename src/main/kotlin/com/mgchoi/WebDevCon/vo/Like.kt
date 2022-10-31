package com.mgchoi.WebDevCon.vo

import lombok.Getter
import lombok.Setter

@Getter
@Setter
data class Like(
    val likeId: Int,
    val userId: Int,
    var marketId: Int?,
    val commentId: Int?
)