package com.template.core.config

import com.template.core.BuildConfig

/****
 * Keep all the common configurations here

 *****/
object Configuration {
    // Deployment Types
    private const val DEV = "dev"
    private const val PROD = "prod"

    // Host URLs
    private const val DEV_URL = "https://api.twitter.com/"
    private const val PROD_URL = "https://api.twitter.com/"
    private const val USERS_ENDPOINT = "users"

    const val REQUEST_TOKEN_ENDPOINT = "request_token"
    const val ACCESS_TOKEN_ENDPOINT = "access_token"

    //Authentication
    const val AUTHORIZATION ="Authorization"
    const val BEARER ="Bearer"

    const val CONNECT_TIMEOUT: Long = 60
    const val READ_TIMEOUT: Long = 60
    const val CALL_TIMEOUT: Long = 60


    val baseURL: String
        get() {

            return when (BuildConfig.FLAVOR) {

                DEV -> DEV_URL

                PROD -> PROD_URL

                else -> DEV_URL
            }
        }
}
