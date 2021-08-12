package com.template.data.datasource.remote.api

import com.template.data.datasource.remote.dto.AuthDto
import com.template.data.datasource.remote.dto.CommonDto
import com.template.domain.entity.request.AuthRequest
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

/****
 * API endpoint of Authentication related service calls

 *****/
interface IAuthApi {

    @GET("stream")
    suspend fun filterTweet(): AuthDto.MultipleTweetPayload

}