package com.shubhamvashishth5.data.repository

import com.shubhamvashishth5.data.constants.NetworkConstants
import com.shubhamvashishth5.domain.common.ResultState
import com.shubhamvashishth5.domain.entity.response.ErrorEntity
import java.io.IOException
import java.io.InterruptedIOException
import java.net.SocketException
import java.net.SocketTimeoutException

abstract class BaseRepositoryImpl {

    suspend fun <T:Any> apiCall( api: suspend () -> T ):ResultState<T>{
        return try {
            val response = api()
            ResultState.Success(response)
        }catch (e:Exception)
        {
            ResultState.Error(handleError(e))
        }
    }

    fun handleError(throwable: Throwable) : ErrorEntity.Error{
        return when(throwable){

            is SocketTimeoutException, is SocketException, is InterruptedIOException -> {
                ErrorEntity.Error(
                    NetworkConstants.NETWORK_ERROR_CODES.SERVICE_UNAVAILABLE,
                    NetworkConstants.NETWORK_ERROR_MESSAGES.SERVICE_UNAVAILABLE
                )
            }

            is IOException-> ErrorEntity.Error(
                NetworkConstants.NETWORK_ERROR_CODES.NO_INTERNET,
                NetworkConstants.NETWORK_ERROR_MESSAGES.NO_INTERNET
            )

            else -> ErrorEntity.Error(
                NetworkConstants.NETWORK_ERROR_CODES.UNEXPECTED_ERROR,
                NetworkConstants.NETWORK_ERROR_MESSAGES.UNEXPECTED_ERROR
            )
        }
    }



}