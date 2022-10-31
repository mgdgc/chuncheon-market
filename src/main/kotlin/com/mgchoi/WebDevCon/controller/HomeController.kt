package com.mgchoi.WebDevCon.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import java.util.Locale
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Controller
class HomeController {

    @GetMapping("/")
    public fun home(locale: Locale, request: HttpServletRequest, response: HttpServletResponse): String {
        return "index"
    }

    @GetMapping("/error")
    public fun error() {

    }

}