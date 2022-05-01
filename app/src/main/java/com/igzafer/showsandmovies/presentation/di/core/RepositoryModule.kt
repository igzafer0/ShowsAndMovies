package com.igzafer.showsandmovies.presentation.di.core

import com.igzafer.showsandmovies.data.repository.movie.MovieRepositoryImpl
import com.igzafer.showsandmovies.data.repository.movie.datasource.MovieCacheDatasource
import com.igzafer.showsandmovies.data.repository.movie.datasource.MovieLocalDatasource
import com.igzafer.showsandmovies.data.repository.movie.datasource.MovieRemoteDatasource
import com.igzafer.showsandmovies.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDatasource: MovieRemoteDatasource,
        movieLocalDatasource: MovieLocalDatasource,
        movieCacheDatasource: MovieCacheDatasource
    ): MovieRepository {
        return MovieRepositoryImpl(
            movieLocalDatasource,
            movieRemoteDatasource,
            movieCacheDatasource
        )
    }
}