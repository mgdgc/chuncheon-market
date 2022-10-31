package com.mgchoi.WebDevCon.dao

import com.mgchoi.WebDevCon.vo.Comment
import org.springframework.stereotype.Repository

@Repository
interface CommentMapper {

    fun insertComment(comment: Comment)
    fun selectComments(marketId: Int): List<Comment>
    fun selectCommentsByUserId(userId: String): List<Comment>
    fun selectGlobalComments(): List<Comment>
    fun deleteComment(commentId: Int)
    fun updateComment(comment: Comment)

}