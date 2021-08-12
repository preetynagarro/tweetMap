package com.template.tweet_list.constants

import androidx.annotation.IntDef
import androidx.annotation.StringDef

/**
 * Keep all the network related constants here

 */
object NetworkConstants {
    @IntDef(
        NETWORK_ERROR_CODES.SERVICE_UNAVAILABLE, NETWORK_ERROR_CODES.MALFORMED_JSON,
        NETWORK_ERROR_CODES.NO_INTERNET, NETWORK_ERROR_CODES.UNEXPECTED_ERROR,
        NETWORK_ERROR_CODES.HTML_RESPONSE_ERROR
    )
    @Retention(AnnotationRetention.SOURCE)
    annotation class NETWORK_ERROR_CODES {
        companion object {
            const val SERVICE_UNAVAILABLE = 500
            const val MALFORMED_JSON = 501
            const val NO_INTERNET = 502
            const val UNEXPECTED_ERROR = 503
            const val HTML_RESPONSE_ERROR = 504
        }
    }

    @StringDef(
        TWITTER_TOKEN.TOKEN, TWITTER_TOKEN.APIKEY,
        TWITTER_TOKEN.APISECRET
    )
    @Retention(AnnotationRetention.SOURCE)
    annotation class TWITTER_TOKEN {
        companion object {
            const val TOKEN = ""
            const val APIKEY = ""
            const val APISECRET = ""
        }
    }
}
