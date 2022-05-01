package com.igzafer.showsandmovies.presentation.di.core

import com.igzafer.showsandmovies.data.db.MovieDAO
import com.igzafer.showsandmovies.data.repository.movie.datasource.MovieLocalDatasource
import com.igzafer.showsandmovies.data.repository.movie.datasourceImpl.MovieLocalDatasourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {
    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao:MovieDAO):MovieLocalDatasource{
        return MovieLocalDatasourceImpl(movieDao)
    }
}