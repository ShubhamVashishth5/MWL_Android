package com.shubhamvashishth5.domain.usecases.movie

import com.shubhamvashishth5.domain.common.ResultState
import com.shubhamvashishth5.domain.entity.response.movie.MovieEntity
import kotlinx.coroutines.flow.Flow

interface MovieUseCase {

    fun getPopularMovies(): Flow<ResultState<MovieEntity.MovieResponse>>

}