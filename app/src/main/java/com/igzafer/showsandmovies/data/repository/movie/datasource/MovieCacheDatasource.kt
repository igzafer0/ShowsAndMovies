package com.igzafer.showsandmovies.data.repository.movie.datasource

import com.igzafer.showsandmovies.data.model.Movie

interface MovieCacheDatasource {
    suspend fun getMoviesFromCache(): List<Movie>
    suspend fun saveMoviesToCache(movies: List<Movie>)
}