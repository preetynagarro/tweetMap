package com.template.data.repository

import com.template.data.datasource.remote.api.TweetApi
import com.template.data.mapper.dtotoentity.map
import com.template.domain.common.ResultState
import com.template.domain.entity.response.auth.AccessTokenEntity
import com.template.domain.entity.response.tweet.TweetEntity
import com.template.domain.repository.TweetRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

/****
 * TweetRepository Implementation

 *****/
class TweetRepositoryImpl(private val tweetApi: TweetApi) :
    BaseRepositoryImpl(), TweetRepository {

    override fun filterTweet( ): Flow<ResultState<TweetEntity.MultipleTweetPayload>>  =
        flow {
        emit(apiCall { tweetApi.filterTweet().map()})
    }.flowOn(Dispatchers.IO)

    override fun accessToken( ): Flow<ResultState<AccessTokenEntity.AccessToken>>  =
        flow {
            emit(apiCall { tweetApi.accessToken().map()})
        }.flowOn(Dispatchers.IO)


}