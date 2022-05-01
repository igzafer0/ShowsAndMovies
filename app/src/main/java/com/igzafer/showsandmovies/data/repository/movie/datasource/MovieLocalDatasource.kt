package com.igzafer.showsandmovies.data.repository.movie.datasource

import com.igzafer.showsandmovies.data.model.Movie

interface MovieLocalDatasource {
    suspend fun getMoviesFromDB(): List<Movie>
    suspend fun saveMoviesToDB(movies: List<Movie>)
    suspend fun clearAll()
}