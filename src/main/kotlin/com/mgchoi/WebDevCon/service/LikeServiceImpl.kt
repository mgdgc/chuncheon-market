package com.mgchoi.WebDevCon.service

import com.mgchoi.WebDevCon.dao.LikeMapper
import com.mgchoi.WebDevCon.exception.MalformedParameterException
import com.mgchoi.WebDevCon.vo.Like
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.lang.Exception

@Service
class LikeServiceImpl : LikeService {

    @Autowired
    private lateinit var mapper: LikeMapper

    override fun like(userId: Int, marketId: Int?, commentId: Int?) {
        if (marketId == null && commentId == null) {
            throw MalformedParameterException()
        }

        val like = Like(0, userId, marketId, commentId)
        if (mapper.selectLike(like) == null) {
            mapper.insertLike(like)
        }
    }

    override fun unlike(userId: Int, marketId: Int?, commentId: Int?) {
        if (marketId == null && commentId == null) {
            throw MalformedParameterException()
        }

        val like = Like(0, userId, marketId, commentId)
        if (mapper.selectLike(like) != null) {
            mapper.deleteLike(like)
        }
    }

    override fun checkLike(userId: Int, marketId: Int?, commentId: Int?): Boolean {
        return mapper.selectLike(Like(0, userId, marketId, commentId)) != null
    }

    override fun countMarketLike(marketId: Int): Int {
        return mapper.countMarketLike(marketId)
    }

    override fun countCommentLike(commentId: Int): Int {
        return mapper.countCommentLike(commentId)
    }
}