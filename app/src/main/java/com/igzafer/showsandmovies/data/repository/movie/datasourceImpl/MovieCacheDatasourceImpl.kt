package com.igzafer.showsandmovies.data.repository.movie.datasourceImpl

import com.igzafer.showsandmovies.data.model.Movie
import com.igzafer.showsandmovies.data.repository.movie.datasource.MovieCacheDatasource

class MovieCacheDatasourceImpl : MovieCacheDatasource {
    private var movieList = ArrayList<Movie>()
    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList= ArrayList(movies)
    }
}