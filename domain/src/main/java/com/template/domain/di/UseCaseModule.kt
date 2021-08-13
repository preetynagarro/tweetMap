package com.template.domain.di

import com.template.domain.usecases.tweet.TweetUseCaseImpl
import com.template.domain.usecases.tweet.TweetUseCase
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

/****
 * Module which provides the factory instance of Usecase

 *****/
object UseCaseModule {
    fun load(){
        loadKoinModules(tweetUseCaseModules)
    }

    val tweetUseCaseModules = module {
        factory<TweetUseCase> { TweetUseCaseImpl(tweetRepository = get()) }
    }
}