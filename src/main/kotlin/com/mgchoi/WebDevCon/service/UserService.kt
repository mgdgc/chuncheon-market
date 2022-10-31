package com.mgchoi.WebDevCon.service

import com.mgchoi.WebDevCon.vo.User


interface UserService {
    fun insertUser(user: User)
    fun selectUser(userId: String): User?
    fun deleteUser(userId: String)
    fun updateUser(user: User)
}