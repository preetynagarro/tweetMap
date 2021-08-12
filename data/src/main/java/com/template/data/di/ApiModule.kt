package com.template.data.di

import com.template.data.datasource.remote.api.IAuthApi
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module
import retrofit2.Retrofit

/****
 * API Module ehich provides the instance of API Endpoints

 *****/
object ApiModule {
    fun load(){
        loadKoinModules(apiModules)
    }

    val apiModules = module {
        single {
            get<Retrofit>().create(IAuthApi::class.java)
        }
    }
}