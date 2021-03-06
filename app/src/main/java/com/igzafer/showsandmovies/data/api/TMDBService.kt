package com.igzafer.showsandmovies.data.api

import com.igzafer.showsandmovies.data.model.MovieList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String,
        @Query("language") lang: String
    ): Response<MovieList>
}