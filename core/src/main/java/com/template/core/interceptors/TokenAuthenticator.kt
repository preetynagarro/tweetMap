package com.template.core.interceptors

import com.template.core.config.Configuration
import com.template.core.config.Configuration.AUTHORIZATION
import com.template.data.datasource.remote.api.TweetApi
import com.template.data.datasource.remote.dto.AccessTokenDto
import com.template.data.repository.handleError
import com.template.domain.common.AppSession
import com.template.domain.common.ResultState
import kotlinx.coroutines.runBlocking
import okhttp3.*
import java.net.HttpURLConnection

class TokenAuthenticator(private val api: Lazy<TweetApi>) : Authenticator {

    override fun authenticate(route: Route?, response: Response): Request? {
        if (response.code == HttpURLConnection.HTTP_UNAUTHORIZED)
            return getUpdatedTokenRequest(response)
        return null
    }

    private fun getUpdatedTokenRequest(response: Response): Request? {
        return runBlocking {
            kotlin.runCatching {
                when (val tokenResponse = getAccessTokenRequest()) {
                    is ResultState.Success -> {
                        AppSession.setAccessToken(tokenResponse.data.access_token)
                        response.request.newBuilder()
                            .header(
                                AUTHORIZATION,
                                "${Configuration.BEARER} ${AppSession.getAccessToken()}"
                            )
                            .build()
                    }
                    else -> null
                }
            }.getOrNull()
        }
    }


    /**
     * Based on user login session return the request to get access token renew token by itself or renew token by refresh token
     */
    private suspend fun getAccessTokenRequest(): ResultState<AccessTokenDto.AccessToken> {
        return try {
            ResultState.Success(
                api.value.accessToken("client_credentials", getOAuthAuthorization())
            )
        } catch (ex: Throwable) {
            ResultState.Error(ex.handleError())
        }
    }

    private fun getOAuthAuthorization(): String {
        return Credentials.basic(Configuration.CLIENT_KEY, Configuration.CLIENT_SECRET)    }
}