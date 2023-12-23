package com.example.gymapp.screens.MovieGenresDetail

import com.example.gymapp.domain.model.MovieGenres

data class MovieGenresDetailScreenState(
    val isLoading: Boolean,
    val data: MovieGenres?,
    val error: String,
){
    fun toUiState() = MovieGenresDetailScreenState(isLoading, data, error)
}

data class MovieGenresDetailModelState(
    val isLoading: Boolean = false,
    val data: MovieGenres? = null,
    val error: String = "",
) {
    fun toUiState() = MovieGenresDetailModelState(isLoading, data, error)
}