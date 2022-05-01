package com.igzafer.showsandmovies.presentation.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.igzafer.showsandmovies.domain.usecase.GetMoviesUseCase
import com.igzafer.showsandmovies.domain.usecase.UpdateMoviesUseCase

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModel() {
    fun getMovies() = liveData {
        val movieList = getMoviesUseCase.execute()
        emit(movieList)
    }

    fun updateMovies() = liveData {
        val movieList = updateMoviesUseCase.execute()
        emit(movieList)
    }
}