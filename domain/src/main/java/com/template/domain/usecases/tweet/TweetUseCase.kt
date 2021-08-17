package com.template.domain.usecases.tweet

import com.template.domain.common.ResultState
import com.template.domain.entity.response.tweet.TweetEntity
import com.template.domain.usecases.base.BaseUseCase
import kotlinx.coroutines.flow.Flow

/****
 * Keep all the authentication related business use cases here

 *****/
interface TweetUseCase : BaseUseCase {
    fun filteredTweet(searchText: String) : Flow<ResultState<TweetEntity.MultipleTweetPayload>>


}