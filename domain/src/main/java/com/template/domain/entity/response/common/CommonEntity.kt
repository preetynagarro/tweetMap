package com.template.domain.entity.response.common

/****
 * Keep all the common entity class here

 *****/
sealed class CommonEntity {

    data class CommonResponse<T>(
        val response: Any?,
        val data: T?
    ) : CommonEntity()

    data class ServerDate(
        val dateTime: String? = ""
    ) : CommonEntity()

    data class Location(
        val latitude: Double,
        val longitude: Double
    )
}