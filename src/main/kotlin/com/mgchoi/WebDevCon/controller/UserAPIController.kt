package com.mgchoi.WebDevCon.controller

import com.mgchoi.WebDevCon.constants.SessionKey
import com.mgchoi.WebDevCon.security.PasswordTool
import com.mgchoi.WebDevCon.service.UserService
import com.mgchoi.WebDevCon.vo.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import java.util.Locale
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@RestController
class UserAPIController {

    @Autowired
    private lateinit var userService: UserService

    @PostMapping("/login")
    public fun login(
        locale: Locale,
        request: HttpServletRequest,
        response: HttpServletResponse,
        userId: String,
        userPw: String
    ) {
        val user = userService.selectUser(userId)

        if (user == null) {
            request.session.setAttribute(SessionKey.KEY_ERROR, "아이디와 비밀번호를 확인하세요.")
            response.sendRedirect("/login")
            return
        } else {
            if (user.userPw == PasswordTool.encryptPassword(userPw, user.salt)) {
                request.session.setAttribute(SessionKey.KEY_USER, user)
                response.sendRedirect("/")
            } else {
                request.session.setAttribute(SessionKey.KEY_ERROR, "아이디와 비밀번호를 확인하세요.")
                response.sendRedirect("/login")
                return
            }
        }
    }

    @GetMapping("/logout")
    public fun logout(locale: Locale, request: HttpServletRequest, response: HttpServletResponse) {
        request.session.invalidate()
        response.sendRedirect("/")
        return
    }

    @PostMapping("/register")
    public fun register(
        locale: Locale,
        request: HttpServletRequest,
        response: HttpServletResponse,
        userId: String,
        userPw: String,
        userName: String
    ) {
        val salt = PasswordTool.SaltGenerator.generate(8)
        val hashedPw = PasswordTool.encryptPassword(userPw, salt)
        val user = User(userId, hashedPw, salt, userName)
        userService.insertUser(user)

        response.sendRedirect("/login")
    }

}