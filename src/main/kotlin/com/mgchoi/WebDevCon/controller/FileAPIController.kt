package com.mgchoi.WebDevCon.controller

import com.mgchoi.WebDevCon.constants.SessionKey
import com.mgchoi.WebDevCon.service.FileService
import com.mgchoi.WebDevCon.service.UserService
import com.mgchoi.WebDevCon.vo.FileVO
import com.mgchoi.WebDevCon.vo.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.UrlResource
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import java.io.File
import java.util.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.Part

@RestController
class FileAPIController {

    @Autowired
    private lateinit var fileService: FileService

    @Value("\${file_base_location}")
    private lateinit var fileBaseLocation: String

    @PostMapping("/file/upload")
    public fun uploadFile(
        locale: Locale,
        request: HttpServletRequest,
        response: HttpServletResponse
    ): FileVO? {

        val user = request.session.getAttribute(SessionKey.KEY_USER) as? User

        if (user == null) {
            request.session.setAttribute(SessionKey.KEY_ERROR, "로그인하거나 회원가입을 해 주세요.")
            response.sendRedirect("/error")
            return null
        }

        val parts: Collection<Part> = request.parts

        val path = File("${fileBaseLocation}/${user.userId}/")
        if (!path.exists()) {
            path.mkdirs()
        }

        for (p in parts) {
            val fileVO = FileVO(
                0,
                p.submittedFileName,
                p.submittedFileName.split(".").last(),
                user.userId,
                ""
            )
            fileService.insertFile(fileVO)
            p.write(File("${fileBaseLocation}/${user.userId}/${fileVO.fileId}.${fileVO.type}").absolutePath)

            return fileService.getLatestFile(user.userId)
        }

        return null
    }

    @GetMapping("/image/{fileId}")
    public fun getImage(
        request: HttpServletRequest,
        @PathVariable("fileId") fileId: Int,
        response: HttpServletResponse
    ): UrlResource? {
        val fileVO = fileService.getFile(fileId)

        if (fileVO == null) {
            response.sendError(404, "Image not found")
            return null
        }

        return UrlResource("file:${fileBaseLocation}/${fileVO.userId}/${fileVO.fileId}.${fileVO.type}")
    }

}