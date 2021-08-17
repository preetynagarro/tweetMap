package com.template.domain.usecases.tweet

import com.template.domain.common.ResultState
import com.template.domain.entity.response.tweet.TweetEntity
import com.template.domain.repository.TweetRepository
import kotlinx.coroutines.flow.Flow

/****
 * Implementation of tweet usecase goes here

 *****/
class TweetUseCaseImpl(private val tweetRepository: TweetRepository) : TweetUseCase {

    override fun filteredTweet(searchText: String): Flow<ResultState<TweetEntity.MultipleTweetPayload>> =
        tweetRepository.filterTweet(searchText)

}