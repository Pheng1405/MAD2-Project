package com.example.gymapp.screens.MovieGenresDetail

import com.example.gymapp.domain.model.MovieGenres

data class MovieGenresDetailScreenState(
    val isLoading: Boolean,
    val genres: MovieGenres? = null,
    val error: String,
){
    fun toUiState() = MovieGenresDetailScreenState(
        isLoading, genres, error
    )
}

data class MovieGenresDetailModelState(
    val isLoading: Boolean = false,
    val genres: MovieGenres? = null,
    val error: String = "",
) {
    fun toUiState() = MovieGenresDetailModelState(
        isLoading, genres, error
    )
}