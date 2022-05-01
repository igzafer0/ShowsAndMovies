package com.igzafer.showsandmovies.domain.usecase

import com.igzafer.showsandmovies.data.model.Movie
import com.igzafer.showsandmovies.domain.repository.MovieRepository

class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute(): List<Movie>? = movieRepository.updateMovies()
}