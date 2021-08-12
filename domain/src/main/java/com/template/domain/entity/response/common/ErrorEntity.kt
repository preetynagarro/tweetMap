package com.template.domain.entity.response.common

/****
 * Keep all the error related model class here

 *****/
sealed class ErrorEntity {
    data class Error(val errorCode: Any?, val errorMessage: String? = "") : ErrorEntity()
}