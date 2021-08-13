package com.template.domain.entity.request


sealed class AccessTokenRequest {


    data class tokenRequest(
        val grant_type: String,
        ) : AccessTokenRequest()




}