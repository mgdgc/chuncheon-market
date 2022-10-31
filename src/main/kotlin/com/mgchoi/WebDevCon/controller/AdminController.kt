package com.mgchoi.WebDevCon.controller

import com.mgchoi.WebDevCon.constants.SessionKey
import com.mgchoi.WebDevCon.service.FileService
import com.mgchoi.WebDevCon.service.MarketService
import com.mgchoi.WebDevCon.service.ParkingService
import com.mgchoi.WebDevCon.vo.FileVO
import com.mgchoi.WebDevCon.vo.Market
import com.mgchoi.WebDevCon.vo.Parking
import com.mgchoi.WebDevCon.vo.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.servlet.ModelAndView
import java.io.File
import java.util.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.Part

@Controller
class AdminController {

    @Value("\${adminId}")
    private lateinit var adminId: String

    @Value("\${adminPw}")
    private lateinit var adminPw: String

    @Autowired
    private lateinit var fileService: FileService

    @Autowired
    private lateinit var marketService: MarketService

    @Autowired
    private lateinit var parkingService: ParkingService

    @Value("\${file_base_location}")
    private lateinit var fileBaseLocation: String

    @GetMapping("/admin")
    public fun admin(): ModelAndView {
        val mav = ModelAndView("admin")

        mav.addObject("files", fileService.getFiles(adminId))
        mav.addObject("markets", marketService.selectMarkets())
        mav.addObject("parkings", parkingService.selectParkings())

        return mav
    }

    @PostMapping("/admin/market")
    public fun registerMarket(
        locale: Locale,
        request: HttpServletRequest,
        response: HttpServletResponse,
        @RequestParam adminId: String,
        @RequestParam adminPw: String,
        @RequestParam marketName: String,
        @RequestParam marketDesc: String,
        @RequestParam longitude: Double,
        @RequestParam latitude: Double,
        @RequestParam openTime: String? = null,
        @RequestParam closeTime: String? = null,
        @RequestParam openDay: String? = null,
        @RequestParam fileId: Int
    ) {
        if (adminId != this.adminId || adminPw != this.adminPw) {
            return
        }

        val market = Market(0, marketName, marketDesc, longitude, latitude, openTime, closeTime, openDay, fileId)
        marketService.insertMarket(market)

        response.sendRedirect("/admin")

    }

    @PostMapping("/admin/parking")
    public fun registerParking(
        locale: Locale,
        request: HttpServletRequest,
        response: HttpServletResponse,
        @RequestParam parkingName: String,
        @RequestParam marketId: Int,
        @RequestParam longitude: Double,
        @RequestParam latitude: Double,
        @RequestParam capacity: Int
    ) {
        if (adminId != this.adminId || adminPw != this.adminPw) {
            return
        }

        val parking = Parking(0, marketId, parkingName, longitude, latitude, capacity)
        parkingService.insertParking(parking)

        response.sendRedirect("/admin")
    }

    @PostMapping("/admin/file")
    public fun uploadFile(
        locale: Locale,
        request: HttpServletRequest,
        response: HttpServletResponse,
        @RequestParam adminId: String,
        @RequestParam adminPw: String,
        @RequestParam(name = "file") file: MultipartFile
    ): FileVO? {

        if (adminId != this.adminId || adminPw != this.adminPw) {
            return null
        }

        val parts: Collection<Part> = request.parts

        val path = File("${fileBaseLocation}/${adminId}/")
        if (!path.exists()) {
            path.mkdirs()
        }

        for (p in parts) {
            println("${p.submittedFileName}")
            if (p.submittedFileName != null) {

                val fileVO = FileVO(
                    0,
                    p.submittedFileName,
                    p.submittedFileName.split(".").last(),
                    adminId,
                    ""
                )
                fileService.insertFile(fileVO)
                val fileFromDB = fileService.getLatestFile(adminId)
                p.write(File("${fileBaseLocation}/${adminId}/${fileFromDB!!.fileId}.${fileVO.type}").absolutePath)

                response.sendRedirect("/admin")
            }
        }

        return null
    }

}