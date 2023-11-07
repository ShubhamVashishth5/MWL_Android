package com.shubhamvashishth5.domain.repository

import com.shubhamvashishth5.domain.common.ResultState
import com.shubhamvashishth5.domain.entity.response.movie.MovieEntity
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    fun getPopularMovies(): Flow<ResultState<MovieEntity.MovieResponse>>

}