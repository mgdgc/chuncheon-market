package com.mgchoi.WebDevCon.service

interface LikeService {

    fun like(userId: Int, marketId: Int? = null, commentId: Int? = null)
    fun unlike(userId: Int, marketId: Int? = null, commentId: Int? = null)
    fun checkLike(userId: Int, marketId: Int? = null, commentId: Int? = null): Boolean
    fun countMarketLike(marketId: Int): Int
    fun countCommentLike(commentId: Int): Int

}