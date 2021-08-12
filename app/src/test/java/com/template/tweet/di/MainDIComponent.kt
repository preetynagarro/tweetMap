package com.template.tweet.di

import com.template.data.di.ApiModule
import com.template.data.di.RepositoryModule
import com.template.domain.di.UseCaseModule

/****
 * Main Koin DI component which helps to configure
 * Mockwebserver, Usecase and repository

 *****/

fun configureTestAppComponent(baseApi: String) = listOf(
    mockwebserverDITest,
    configureNetworkModuleForTest(baseApi),
    ApiModule.apiModules,
    UseCaseModule.authUSeCaseModules,
    RepositoryModule.repositoryModules
)