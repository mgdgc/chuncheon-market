package com.mgchoi.WebDevCon.controller

import com.mgchoi.WebDevCon.service.MarketService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.servlet.ModelAndView
import java.util.Locale
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Controller
class HomeController {

    @Autowired
    private lateinit var marketService: MarketService

    @GetMapping("/")
    public fun home(locale: Locale, request: HttpServletRequest, response: HttpServletResponse): ModelAndView {
        val mav = ModelAndView("index")

        mav.addObject("markets", marketService.selectMarkets())
        return mav
    }

    @GetMapping("/error")
    public fun error() {

    }

}