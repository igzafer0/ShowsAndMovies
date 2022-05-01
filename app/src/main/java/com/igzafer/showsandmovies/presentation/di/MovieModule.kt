package com.igzafer.showsandmovies.presentation.di

import com.igzafer.showsandmovies.domain.usecase.GetMoviesUseCase
import com.igzafer.showsandmovies.domain.usecase.UpdateMoviesUseCase
import com.igzafer.showsandmovies.presentation.view_model.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {
    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ):MovieViewModelFactory {
        return MovieViewModelFactory(getMoviesUseCase,updateMoviesUseCase)
    }
}