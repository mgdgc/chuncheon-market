package com.mgchoi.WebDevCon.service

import com.mgchoi.WebDevCon.dao.CommentMapper
import com.mgchoi.WebDevCon.vo.Comment
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CommentServiceImpl : CommentService {

    @Autowired
    private lateinit var mapper: CommentMapper

    override fun insertComment(comment: Comment) {
        mapper.insertComment(comment)
    }

    override fun selectComments(marketId: Int): List<Comment> {
        return mapper.selectComments(marketId)
    }

    override fun selectCommentsByUserId(userId: String): List<Comment> {
        return mapper.selectCommentsByUserId(userId)
    }

    override fun selectGlobalComments(): List<Comment> {
        return mapper.selectGlobalComments()
    }

    override fun deleteComment(commentId: Int) {
        mapper.deleteComment(commentId)
    }

    override fun updateComment(comment: Comment) {
        mapper.updateComment(comment)
    }
}