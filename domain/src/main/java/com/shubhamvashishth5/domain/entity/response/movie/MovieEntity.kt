package com.shubhamvashishth5.domain.entity.response.movie

sealed class MovieEntity {
    data class Movie(
        val adult: Boolean,
        val backdropPath: String?,
        val genreIds: List<Int>,
        val id: Long,
        val originalLanguage: String,
        val originalTitle: String,
        val overview: String,
        val popularity: Double,
        val posterPath: String?,
        val releaseDate: String,
        val title: String,
        val video: Boolean,
        val voteAverage: Double,
        val voteCount: Int
    )

    data class MovieResponse(
        val page: Int,
        val results: List<Movie>,
        val totalPages: Int,
        val totalResults: Int
    )
}