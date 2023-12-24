package com.example.gymapp.screens.Home

import com.example.gymapp.domain.model.MovieGenres
import com.example.gymapp.domain.model.MovieModel

data class HomeScreenState(
    val isLoading: Boolean,
    val movie: List<MovieModel>?,
    val error: String,
){
    fun toUiState() = HomeScreenState(
        isLoading, movie, error
    )
}

data class HomeModelState(
    val isLoading: Boolean = false,
    val movie: List<MovieModel>? = emptyList(),
    val error: String = "",
) {
    fun toUiState() = HomeModelState(
        isLoading, movie, error
    )
}