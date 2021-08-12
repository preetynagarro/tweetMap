package com.template.domain.usecases.auth

import com.template.domain.common.ResultState
import com.template.domain.entity.response.auth.AuthEntity
import com.template.domain.entity.response.common.CommonEntity
import com.template.domain.usecases.base.BaseUseCase
import kotlinx.coroutines.flow.Flow

/****
 * Keep all the authentication related business use cases here

 *****/
interface IAuthUseCase : BaseUseCase {

    fun filteredTweet() : Flow<ResultState<AuthEntity.MultipleTweetPayload>>


}