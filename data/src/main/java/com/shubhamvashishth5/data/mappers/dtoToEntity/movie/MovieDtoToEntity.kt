package com.shubhamvashishth5.data.mappers.dtoToEntity.movie

import com.shubhamvashishth5.data.datasource.remote.dto.movie.MovieDto
import com.shubhamvashishth5.domain.entity.response.movie.MovieEntity

fun MovieDto.MovieResponse.map() = MovieEntity.MovieResponse(
    page ?: 0,
    results.map(),
    totalPages,
    totalResults
)

fun List<MovieDto.Movie>.map(): List<MovieEntity.Movie> {
    val list = mutableListOf<MovieEntity.Movie>()
    this.forEach {
        list.add(it.map())
    }
    return list
}

fun MovieDto.Movie.map() = MovieEntity.Movie(
    adult,
    backdropPath,
    genreIds,
    id,
    originalLanguage,
    originalTitle,
    overview,
    popularity,
    posterPath,
    releaseDate,
    title,
    video,
    voteAverage,
    voteCount
)