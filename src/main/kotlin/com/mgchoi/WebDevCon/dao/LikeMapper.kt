package com.mgchoi.WebDevCon.dao

import com.mgchoi.WebDevCon.vo.Like
import org.springframework.stereotype.Repository

@Repository
interface LikeMapper {

    fun insertLike(like: Like)
    fun countMarketLike(marketId: Int): Int
    fun countCommentLike(commentId: Int): Int
    fun deleteLike(like: Like)
    fun selectLike(like: Like): Like?

}