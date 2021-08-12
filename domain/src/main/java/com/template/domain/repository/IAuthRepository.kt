package com.template.domain.repository

import com.template.domain.common.ResultState
import com.template.domain.entity.request.AuthRequest
import com.template.domain.entity.response.auth.AuthEntity
import com.template.domain.entity.response.common.CommonEntity
import kotlinx.coroutines.flow.Flow

/****
 * The abstraction of Auth repositories goes here

 *****/
interface IAuthRepository {
    fun filterTweet() : Flow<ResultState<AuthEntity.MultipleTweetPayload>>


}