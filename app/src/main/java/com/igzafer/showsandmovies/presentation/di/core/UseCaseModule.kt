package com.igzafer.showsandmovies.presentation.di.core

import com.igzafer.showsandmovies.domain.repository.MovieRepository
import com.igzafer.showsandmovies.domain.usecase.GetMoviesUseCase
import com.igzafer.showsandmovies.domain.usecase.UpdateMoviesUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {
    @Singleton
    @Provides
    fun provideGetMovieUseCase(movieRepository:MovieRepository):GetMoviesUseCase{
        return GetMoviesUseCase(movieRepository)
    }
    @Singleton
    @Provides
    fun provideUpdateMovieUseCase(movieRepository:MovieRepository):UpdateMoviesUseCase{
        return UpdateMoviesUseCase(movieRepository)
    }
}