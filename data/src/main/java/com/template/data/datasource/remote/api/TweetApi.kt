package com.template.data.datasource.remote.api

import com.template.data.datasource.remote.dto.AccessTokenDto
import com.template.data.datasource.remote.dto.TweetDto
import retrofit2.http.*

/****
 * API endpoint of Authentication related service calls

 *****/
interface TweetApi {

    @GET("2/tweets/search/recent")
    suspend fun filterTweet(
        @Query(
            "query",
            encoded = true
        ) query: String?
    ): TweetDto.MultipleTweetPayload

    @POST("oauth2/token")
    suspend fun accessToken(
        @Query("grant_type") grantType: String,
        @Header("Authorization") authHeader: String
    ): AccessTokenDto.AccessToken
}