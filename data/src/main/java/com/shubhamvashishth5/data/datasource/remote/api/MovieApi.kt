package com.shubhamvashishth5.data.datasource.remote.api

import com.shubhamvashishth5.data.datasource.remote.dto.movie.MovieDto
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface MovieApi {

    @GET("movie/popular")
    suspend fun getPopularMovies(@QueryMap queryMap: Map<String,String>) : MovieDto.MovieResponse

}