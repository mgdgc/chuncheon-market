package com.mgchoi.WebDevCon.dao

import com.mgchoi.WebDevCon.vo.User
import org.springframework.stereotype.Repository

@Repository
interface UserMapper {

    fun insertUser(user: User)
    fun selectUser(userId: String): User?
    fun deleteUser(userId: String)
    fun updateUser(user: User)

}