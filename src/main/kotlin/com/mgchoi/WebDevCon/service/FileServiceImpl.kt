package com.mgchoi.WebDevCon.service

import com.mgchoi.WebDevCon.dao.FileMapper
import com.mgchoi.WebDevCon.vo.FileVO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FileServiceImpl : FileService {

    @Autowired
    private lateinit var mapper: FileMapper

    override fun insertFile(fileVO: FileVO) {
        mapper.insertFile(fileVO)
    }

    override fun getFile(fileId: Int): FileVO? {
        return mapper.getFile(fileId)
    }

    override fun getLatestFile(userId: String): FileVO? {
        return mapper.getLatestFile(userId)
    }

    override fun deleteFile(fileId: Int) {
        mapper.deleteFile(fileId)
    }
}