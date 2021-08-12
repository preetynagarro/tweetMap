package com.template.data.di

import com.template.data.repository.AuthRepositoryImpl
import com.template.domain.repository.IAuthRepository
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

/****
 * DI module which provides the factory repository instances

 *****/
object RepositoryModule {
    fun load() {
        loadKoinModules(repositoryModules)
    }

    val repositoryModules = module {
        factory<IAuthRepository>{ AuthRepositoryImpl(authApi = get()) }
    }
}