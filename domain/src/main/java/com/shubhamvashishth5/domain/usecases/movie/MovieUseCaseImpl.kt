package com.shubhamvashishth5.domain.usecases.movie

import com.shubhamvashishth5.domain.common.ResultState
import com.shubhamvashishth5.domain.entity.response.movie.MovieEntity
import com.shubhamvashishth5.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

class MovieUseCaseImpl(private val movieRepository: MovieRepository) : MovieUseCase {

    override fun getPopularMovies(): Flow<ResultState<MovieEntity.MovieResponse>> {
        return movieRepository.getPopularMovies()
    }


}