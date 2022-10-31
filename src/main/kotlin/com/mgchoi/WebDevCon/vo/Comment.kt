package com.mgchoi.WebDevCon.vo

import lombok.Getter
import lombok.Setter

@Getter
@Setter
data class Comment(
    val commentId: Int,
    val userId: String,
    val marketId: Int? = null,
    var content: String,
    var fileId: Int? = null,
    var created: String
)
