package com.template.data.repository

import com.template.data.datasource.remote.api.IAuthApi
import com.template.data.mapper.dtotoentity.map
import com.template.domain.common.ResultState
import com.template.domain.entity.request.AuthRequest
import com.template.domain.entity.response.auth.AuthEntity
import com.template.domain.entity.response.common.CommonEntity
import com.template.domain.repository.IAuthRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

/****
 * AuthRepository Implementation

 *****/
class AuthRepositoryImpl(private val authApi: IAuthApi) :
    BaseRepositoryImpl(), IAuthRepository {

    override fun filterTweet( ): Flow<ResultState<AuthEntity.MultipleTweetPayload>>  =
        flow {
        emit(apiCall { authApi.filterTweet().map()})
    }.flowOn(Dispatchers.IO)


}