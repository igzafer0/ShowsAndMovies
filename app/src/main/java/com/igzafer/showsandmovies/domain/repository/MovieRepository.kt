package com.igzafer.showsandmovies.domain.repository

import com.igzafer.showsandmovies.data.model.Movie

interface MovieRepository {
    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies(): List<Movie>?
}