package com.template.domain.entity.response.auth

/****
 * Keep all the authentication use case related entities over here.
 * Entity model contains only the fields needed for UI

 *****/
sealed class AccessTokenEntity {

    data class AccessToken(
        val token_type: String?=null,
        val access_token:String?=null

    ) : AccessTokenEntity()


}