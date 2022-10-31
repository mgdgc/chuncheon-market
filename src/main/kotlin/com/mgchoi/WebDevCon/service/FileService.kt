package com.mgchoi.WebDevCon.service

import com.mgchoi.WebDevCon.vo.FileVO

interface FileService {
    fun insertFile(fileVO: FileVO)
    fun getFile(fileId: Int): FileVO?
    fun getLatestFile(userId: String): FileVO?
    fun deleteFile(fileId: Int)
}