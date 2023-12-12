package com.example.gymapp.screens.MovieDetail

import com.example.gymapp.domain.model.MovieGenres

data class MovieDetailScreenState(
    val isLoading: Boolean,
    val data: List<MovieGenres>?,
    val error: String,
){
    fun toUiState() = MovieDetailScreenState(
        isLoading, data, error
    )
}

data class MovieDetailModelState(
    val isLoading: Boolean = false,
    val data: List<MovieGenres>? = emptyList(),
    val error: String = "",
) {
    fun toUiState() = MovieDetailScreenState(
        isLoading, data, error
    )
}