package com.template.tweet.di.component

import com.template.tweet.di.module.ViewModelModule
import com.template.core.di.module.application.RetrofitModule
import com.template.tweet.di.module.ApplicationModule
import com.template.core.di.module.application.OkhttpModule
import com.template.data.di.ApiModule
import com.template.data.di.RepositoryModule
import com.template.domain.di.UseCaseModule
import com.template.tweet_list.di.OnboardingViewModelModule

/****
 * Application component which loads all the Koin Modules
 *****/
object ApplicationComponent {
    fun loadAllModules(){
        RetrofitModule.load()
        OkhttpModule.load()
        RepositoryModule.load()
        UseCaseModule.load()
        ApiModule.load()
        ApplicationModule.load()
        ViewModelModule.load()
        OnboardingViewModelModule.load()

    }
}