package com.example.gymapp.screens.MovieGenres

import com.example.gymapp.domain.model.MovieGenres

data class MovieGenresScreenState(
    val isLoading: Boolean,
    val category: List<MovieGenres>?,
    val error: String,
)

data class ShopViewModelState(
    val isLoading: Boolean = false,
    val category: List<MovieGenres>? = emptyList(),
    val error: String = "",
) {
    fun toUiState() = MovieGenresScreenState(
        isLoading, category, error
    )
}