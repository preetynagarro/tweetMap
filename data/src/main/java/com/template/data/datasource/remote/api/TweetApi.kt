package com.template.data.datasource.remote.api

import com.template.data.datasource.remote.dto.AccessTokenDto
import com.template.data.datasource.remote.dto.TweetDto
import com.template.domain.entity.response.auth.AccessTokenEntity
import retrofit2.http.GET
import retrofit2.http.POST

/****
 * API endpoint of Authentication related service calls

 *****/
interface TweetApi {

    @GET("2/tweets/stream")
    suspend fun filterTweet(): TweetDto.MultipleTweetPayload

    @POST("oauth2/token")
    suspend fun accessToken(): AccessTokenDto.AccessToken

}