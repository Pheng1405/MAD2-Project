package com.example.gymapp.screens.Movie

import com.example.gymapp.domain.model.MovieModel

data class MovieScreenState(
    val isLoading: Boolean,
    val movie: List<MovieModel>?,
    val error: String,
){
    fun toUiState() = MovieScreenState(
        isLoading, movie, error
    )
}

data class MovieModelState(
    val isLoading: Boolean = false,
    val movie: List<MovieModel>? = emptyList(),
    val error: String = "",
) {
    fun toUiState() = MovieModelState(
        isLoading, movie, error
    )
}