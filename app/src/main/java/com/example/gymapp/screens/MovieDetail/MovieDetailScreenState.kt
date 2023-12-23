package com.example.gymapp.screens.MovieDetail

import com.example.gymapp.domain.model.MovieModel

data class MovieDetailScreenState(
    val isLoading: Boolean,
    val movie: MovieModel,
    val error: String,
){
    fun toUiState() = MovieDetailScreenState(
        isLoading, movie, error
    )
}

data class MovieDetailModelState(
    val isLoading: Boolean = false,
    val movie: MovieModel? = null,
    val error: String = "",
) {
    fun toUiState() = movie?.let {
        MovieDetailScreenState(
        isLoading, it, error
    )
    }
}