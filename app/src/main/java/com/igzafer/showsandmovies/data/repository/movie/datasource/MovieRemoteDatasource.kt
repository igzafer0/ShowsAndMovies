package com.igzafer.showsandmovies.data.repository.movie.datasource

import com.igzafer.showsandmovies.data.model.MovieList
import retrofit2.Response

interface MovieRemoteDatasource {
    suspend fun getMovies(): Response<MovieList>
}