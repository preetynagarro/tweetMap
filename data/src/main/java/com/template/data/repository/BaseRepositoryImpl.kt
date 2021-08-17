package com.template.data.repository
import android.util.MalformedJsonException
import com.google.gson.GsonBuilder
import com.template.data.constants.NetworkConstants
import com.template.data.datasource.remote.dto.ErrorDto
import com.template.domain.common.ResultState
import com.template.domain.entity.response.common.ErrorEntity
import okhttp3.ResponseBody
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException
import java.io.InterruptedIOException
import java.net.SocketException
import java.net.SocketTimeoutException
abstract class BaseRepositoryImpl {
    protected suspend fun <T : Any> apiCall(call: suspend () -> T): ResultState<T> {
        return try {
            val response = call()
            ResultState.Success(response)
        } catch (ex: Throwable) {
            ResultState.Error(handleError(ex))
        }
    }
    private fun handleError(throwable: Throwable): ErrorEntity.Error {
        return throwable.handleError()
    }
}
private const val logFormatter: String = "%s | %s"
/**
 * This method serializes the errorbody to ErrorDto class
 */
fun getError(responseBody: ResponseBody?): ErrorDto.ErrorResponse? {
    return try {
        val response = GsonBuilder().create()
            .fromJson(responseBody?.string(), ErrorDto.ErrorResponse::class.java)
        Timber.e("API Error Object: %s", response?.toString())
        response
    } catch (ex: Exception) {
        ErrorDto.ErrorResponse(
            ErrorDto.Error(
                "", NetworkConstants.NETWORK_ERROR_CODES.UNEXPECTED_ERROR,
                NetworkConstants.NETWORK_ERROR_MESSAGES.UNEXPECTED_ERROR, null
            )
        )
    }
}
fun Throwable.handleError(): ErrorEntity.Error {
    return when (this) {
        is SocketTimeoutException, is SocketException, is InterruptedIOException -> {
            Timber.e(
                logFormatter,
                this.message.toString(),
                NetworkConstants.NETWORK_ERROR_MESSAGES.SERVICE_UNAVAILABLE
            )
            ErrorEntity.Error(
                NetworkConstants.NETWORK_ERROR_CODES.SERVICE_UNAVAILABLE,
                NetworkConstants.NETWORK_ERROR_MESSAGES.SERVICE_UNAVAILABLE
            )
        }
        is MalformedJsonException -> {
            Timber.e(
                logFormatter,
                this.message.toString(),
                NetworkConstants.NETWORK_ERROR_MESSAGES.MALFORMED_JSON
            )
            ErrorEntity.Error(
                NetworkConstants.NETWORK_ERROR_CODES.MALFORMED_JSON,
                NetworkConstants.NETWORK_ERROR_MESSAGES.MALFORMED_JSON
            )
        }
        is IOException -> {
            Timber.e(
                logFormatter,
                this.message.toString(),
                NetworkConstants.NETWORK_ERROR_MESSAGES.NO_INTERNET
            )
            ErrorEntity.Error(
                NetworkConstants.NETWORK_ERROR_CODES.NO_INTERNET,
                NetworkConstants.NETWORK_ERROR_MESSAGES.NO_INTERNET
            )
        }
        is HttpException -> {
            Timber.e(
                logFormatter,
                this.response()?.toString() ?: this.message().toString(),
                ""
            )
            val errorResponse: ErrorDto.ErrorResponse? =
                getError(this.response()?.errorBody())
            if (errorResponse?.error == null) {
                ErrorEntity.Error(
                    NetworkConstants.NETWORK_ERROR_CODES.UNEXPECTED_ERROR,
                    NetworkConstants.NETWORK_ERROR_MESSAGES.UNEXPECTED_ERROR
                )
            } else {
                if (errorResponse.error.code == "ValidationError" && errorResponse.error.fieldErrors?.isNotEmpty() == true) {
                    errorResponse.error.errorUserMsg =
                        errorResponse.error.fieldErrors[0].message
                }
                Timber.e(
                    logFormatter,
                    errorResponse.error.code,
                    errorResponse.error.errorUserMsg.toString()
                )
                ErrorEntity.Error(
                    errorResponse.error.code,
                    errorResponse.error.errorUserMsg.toString()
                )
            }
        }
        else -> {
            Timber.e(
                logFormatter, NetworkConstants.NETWORK_ERROR_MESSAGES.UNEXPECTED_ERROR,
                NetworkConstants.NETWORK_ERROR_MESSAGES.UNEXPECTED_ERROR
            )
            ErrorEntity.Error(
                NetworkConstants.NETWORK_ERROR_CODES.UNEXPECTED_ERROR,
                NetworkConstants.NETWORK_ERROR_MESSAGES.UNEXPECTED_ERROR
            )
        }
    }
}