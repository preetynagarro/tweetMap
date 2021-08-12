package com.template.tweet_list.di

import com.template.tweet_list.view.fragment.tweetList.TweetViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module


object TweetListViewModelModule {
    fun load() {
        loadKoinModules(module {

            viewModel {
                TweetViewModel(get())
            }
        })
    }
}