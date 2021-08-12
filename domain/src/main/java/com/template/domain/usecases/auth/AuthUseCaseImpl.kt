package com.template.domain.usecases.auth

import com.template.domain.common.ResultState
import com.template.domain.entity.response.auth.AuthEntity
import com.template.domain.entity.response.common.CommonEntity
import com.template.domain.repository.IAuthRepository
import kotlinx.coroutines.flow.Flow

/****
 * Implementation of auth usecase goes here

 *****/
class AuthUseCaseImpl(private val authRepository: IAuthRepository) : IAuthUseCase {

    override fun filteredTweet(): Flow<ResultState<AuthEntity.MultipleTweetPayload>> =
        authRepository.filterTweet()
}