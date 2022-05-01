package com.igzafer.showsandmovies.data.repository.movie.datasourceImpl

import com.igzafer.showsandmovies.data.db.MovieDAO
import com.igzafer.showsandmovies.data.model.Movie
import com.igzafer.showsandmovies.data.repository.movie.datasource.MovieLocalDatasource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDatasourceImpl(private val movieDAO: MovieDAO): MovieLocalDatasource {
    override suspend fun getMoviesFromDB(): List<Movie> {
        return movieDAO.getAllMovies()
    }

    override suspend fun saveMoviesToDB(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDAO.saveMovies(movies)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDAO.deleteAllMovies()
        }
    }
}