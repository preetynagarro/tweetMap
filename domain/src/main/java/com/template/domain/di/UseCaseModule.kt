package com.template.domain.di

import com.template.domain.usecases.auth.AuthUseCaseImpl
import com.template.domain.usecases.auth.IAuthUseCase
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

/****
 * Module which provides the factory instance of Usecase

 *****/
object UseCaseModule {
    fun load(){
        loadKoinModules(authUSeCaseModules)
    }

    val authUSeCaseModules = module {
        factory<IAuthUseCase> { AuthUseCaseImpl(authRepository = get()) }
    }
}