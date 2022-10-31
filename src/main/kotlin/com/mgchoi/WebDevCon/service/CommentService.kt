package com.mgchoi.WebDevCon.service

import com.mgchoi.WebDevCon.vo.Comment

interface CommentService {

    fun insertComment(comment: Comment)
    fun selectComments(marketId: Int): List<Comment>
    fun selectCommentsByUserId(userId: String): List<Comment>
    fun selectGlobalComments(): List<Comment>
    fun deleteComment(commentId: Int)
    fun updateComment(comment: Comment)
}