package com.template.domain.usecases.tweet

import com.template.domain.common.ResultState
import com.template.domain.entity.response.auth.AccessTokenEntity
import com.template.domain.entity.response.tweet.TweetEntity
import com.template.domain.usecases.base.BaseUseCase
import kotlinx.coroutines.flow.Flow

/****
 * Keep all the authentication related business use cases here

 *****/
interface TweetUseCase : BaseUseCase {
    fun filteredTweet() : Flow<ResultState<TweetEntity.MultipleTweetPayload>>
    fun accessToken() : Flow<ResultState<AccessTokenEntity.AccessToken>>


}