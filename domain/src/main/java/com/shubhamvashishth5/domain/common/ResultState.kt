package com.shubhamvashishth5.domain.common

import com.shubhamvashishth5.domain.entity.response.ErrorEntity

sealed class ResultState<T>{

    class Success<T>(val data: T) : ResultState<T>()

    class Error<T>(val error:ErrorEntity.Error?) : ResultState<T>()

    class Loading<T> : ResultState<T>()
}
