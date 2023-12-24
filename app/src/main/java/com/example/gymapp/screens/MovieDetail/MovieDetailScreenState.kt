package com.example.gymapp.screens.MovieDetail

import com.example.gymapp.domain.model.MovieModel
import com.example.gymapp.screens.MovieGenresDetail.MovieGenresDetailModelState

data class MovieDetailScreenState(
    val isLoading: Boolean,
    val data: MovieModel?,
    val relatedMovies: List<MovieModel>? = emptyList(),
    val error: String,
){
    fun toUiState() = MovieDetailScreenState(isLoading, data, relatedMovies, error)
}

data class MovieDetailModelState(
    val isLoading: Boolean = false,
    val data: MovieModel? = null,
    val relatedMovies: List<MovieModel>? = emptyList(),
    val error: String = "",
) {
    fun toUiState() = MovieDetailModelState(isLoading, data, relatedMovies, error)
}