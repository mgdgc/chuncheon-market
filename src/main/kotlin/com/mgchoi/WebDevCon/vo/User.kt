package com.mgchoi.WebDevCon.vo

import lombok.Getter
import lombok.Setter

@Getter
@Setter
data class User(
    var userId: String,
    var userPw: String,
    var salt: String,
    var userName: String
) {
}