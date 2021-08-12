package com.template.tweet_list.di

import com.template.tweet_list.view.fragment.dashboard.DashboardViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module


object OnboardingViewModelModule {
    fun load() {
        loadKoinModules(module {

            viewModel {
                DashboardViewModel(get())
            }
        })
    }
}