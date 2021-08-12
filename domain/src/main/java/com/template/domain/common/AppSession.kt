package com.template.domain.common

object AppSession {
    private var accessToken: String? = null

    fun getAccessToken(): String? {
        return accessToken ?: ""
    }
    fun setAccessToken(token: String?) {
        this.accessToken = token
    }

}