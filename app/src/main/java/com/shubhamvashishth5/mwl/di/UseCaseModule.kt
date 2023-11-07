package com.shubhamvashishth5.mwl.di

import com.shubhamvashishth5.domain.repository.MovieRepository
import com.shubhamvashishth5.domain.usecases.movie.MovieUseCase
import com.shubhamvashishth5.domain.usecases.movie.MovieUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    @Singleton
    fun provideMovieUseCaseImpl(movieRepository: MovieRepository):MovieUseCase{
        return MovieUseCaseImpl(movieRepository)
    }

}