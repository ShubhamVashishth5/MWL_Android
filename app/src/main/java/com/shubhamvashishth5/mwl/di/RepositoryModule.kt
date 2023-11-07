package com.shubhamvashishth5.mwl.di

import com.shubhamvashishth5.data.datasource.remote.api.MovieApi
import com.shubhamvashishth5.data.repository.movie.MovieRepositoryImpl
import com.shubhamvashishth5.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun provideMovieRepositoryImpl(movieApi:MovieApi):MovieRepository{
        return MovieRepositoryImpl(movieApi)
    }

}