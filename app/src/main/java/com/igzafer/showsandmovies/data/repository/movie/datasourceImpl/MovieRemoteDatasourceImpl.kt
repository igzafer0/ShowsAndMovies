package com.igzafer.showsandmovies.data.repository.movie.datasourceImpl

import com.igzafer.showsandmovies.data.api.TMDBService
import com.igzafer.showsandmovies.data.model.MovieList
import com.igzafer.showsandmovies.data.repository.movie.datasource.MovieRemoteDatasource
import retrofit2.Response

class MovieRemoteDatasourceImpl(private val tmdbService: TMDBService, private val apiKey: String) :
    MovieRemoteDatasource {
    override suspend fun getMovies(): Response<MovieList> {
        return tmdbService.getPopularMovies(apiKey)
    }
}