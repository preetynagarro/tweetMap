package com.template.tweet.di

import okhttp3.mockwebserver.MockWebServer
import org.koin.dsl.module

/****
 * Creates Mockwebserver instance for testing

 *****/

val mockwebserverDITest = module {
    factory {
        MockWebServer()
    }
}