package com.mgchoi.WebDevCon.service

import com.mgchoi.WebDevCon.dao.UserMapper
import com.mgchoi.WebDevCon.vo.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl : UserService {

    @Autowired
    private lateinit var mapper: UserMapper

    override fun insertUser(user: User) {
        mapper.insertUser(user)
    }

    override fun selectUser(userId: String): User? {
        return mapper.selectUser(userId)
    }

    override fun deleteUser(userId: String) {
        mapper.deleteUser(userId)
    }

    override fun updateUser(user: User) {
        mapper.updateUser(user)
    }

}