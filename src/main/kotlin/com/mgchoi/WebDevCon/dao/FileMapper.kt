package com.mgchoi.WebDevCon.dao

import com.mgchoi.WebDevCon.vo.FileVO
import org.springframework.stereotype.Repository

@Repository
interface FileMapper {

    fun insertFile(fileVO: FileVO)
    fun getFile(fileId: Int): FileVO
    fun getLatestFile(userId: String): FileVO?
    fun deleteFile(fileId: Int)

}