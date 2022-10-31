package com.mgchoi.WebDevCon.vo

import lombok.Getter
import lombok.Setter

@Getter
@Setter
data class FileVO(
    val fileId: Int,
    var originalName: String,
    var type: String,
    var userId: String,
    var uploaded: String
)
