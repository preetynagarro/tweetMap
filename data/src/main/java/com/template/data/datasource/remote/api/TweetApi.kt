package com.template.data.datasource.remote.api

import com.template.data.datasource.remote.dto.TweetDto
import retrofit2.http.GET

/****
 * API endpoint of Authentication related service calls

 *****/
interface TweetApi {

    @GET("stream")
    suspend fun filterTweet(): TweetDto.MultipleTweetPayload

}