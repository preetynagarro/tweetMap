package com.template.domain.entity.request


sealed class AuthRequest {

    abstract val userId: String
    abstract val password: String

    data class SignupRequest(
        override val userId: String,
        override val password: String,
        val tnc: Boolean
    ) : AuthRequest()

    data class SigninRequest(
        override val userId: String,
        override val password: String,
        val loginType: Int,
        val enableRememberMe: Boolean,
        val encryptionToken: String? = "",
        val notificationToken: String? = ""
    ) : AuthRequest()


}