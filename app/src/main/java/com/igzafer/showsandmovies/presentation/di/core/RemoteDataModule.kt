package com.igzafer.showsandmovies.presentation.di.core

import com.igzafer.showsandmovies.data.api.TMDBService
import com.igzafer.showsandmovies.data.repository.movie.datasource.MovieRemoteDatasource
import com.igzafer.showsandmovies.data.repository.movie.datasourceImpl.MovieRemoteDatasourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {
    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDatasource {
        return MovieRemoteDatasourceImpl(tmdbService, apiKey)
    }
}