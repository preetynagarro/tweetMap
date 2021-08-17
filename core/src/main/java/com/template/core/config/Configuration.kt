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



    //Authentication
    const val AUTHORIZATION ="Authorization"
    const val CLIENT_KEY ="V1JYSxUgpeMlKnJ8EOF64nliZ"
    const val CLIENT_SECRET ="l0mlhMnSlBdxnruYFjbOuq8Y6CFOjrj7KWajMyVheMHaSXYraN"
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
