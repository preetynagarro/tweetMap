package com.template.data.datasource.remote.dto

import com.google.gson.annotations.SerializedName

/****
 * Keep all the AUTH related DTOs here

 *****/
sealed class AccessTokenDto {

    data class AccessToken(
       @SerializedName("token_type") val token_type: String? = null,
        @SerializedName("access_token") val access_token: String? = null
    ) : AccessTokenDto()

   
}