package com.shubhamvashishth5.data.repository.movie

import com.shubhamvashishth5.data.datasource.remote.api.MovieApi
import com.shubhamvashishth5.data.datasource.remote.request.movie.MovieRequest
import com.shubhamvashishth5.data.mappers.dtoToEntity.movie.map
import com.shubhamvashishth5.data.repository.BaseRepositoryImpl
import com.shubhamvashishth5.domain.common.ResultState
import com.shubhamvashishth5.domain.entity.response.movie.MovieEntity
import com.shubhamvashishth5.domain.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class MovieRepositoryImpl(private val movieApi: MovieApi) : BaseRepositoryImpl(), MovieRepository {

    override fun getPopularMovies(): Flow<ResultState<MovieEntity.MovieResponse>> {
        return flow {
            emit(
                apiCall {
                    movieApi.getPopularMovies(MovieRequest.PopularRequestQuery("en-US", 1).toQuery())
                        .map()
                })
        }.flowOn(Dispatchers.IO)
    }

}