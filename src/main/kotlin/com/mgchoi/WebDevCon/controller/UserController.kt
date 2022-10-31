package com.mgchoi.WebDevCon.controller

import com.mgchoi.WebDevCon.constants.SessionKey
import com.mgchoi.WebDevCon.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import java.util.Locale
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Controller
class UserController {

    @Autowired
    private lateinit var userService: UserService

    @GetMapping("/login")
    public fun login(locale: Locale, request: HttpServletRequest, response: HttpServletResponse): String {
        return "login"
    }

    @GetMapping("/register")
    public fun register(locale: Locale, request: HttpServletRequest, response: HttpServletResponse): String {
        return "register"
    }

}