package com.template.domain.repository

import com.template.domain.common.ResultState
import com.template.domain.entity.response.auth.AccessTokenEntity
import com.template.domain.entity.response.tweet.TweetEntity
import kotlinx.coroutines.flow.Flow

/****
 * The abstraction of Auth repositories goes here

 *****/
interface TweetRepository {
    fun filterTweet() : Flow<ResultState<TweetEntity.MultipleTweetPayload>>
    fun accessToken(): Flow<ResultState<AccessTokenEntity.AccessToken>>


}