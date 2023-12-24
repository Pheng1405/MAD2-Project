package com.example.gymapp.screens.MovieGenresDetail

import com.example.gymapp.domain.model.AllMovieModel
import com.example.gymapp.domain.model.MovieGenres
import com.example.gymapp.domain.model.MovieModel

data class MovieGenresDetailScreenState(
    val isLoading: Boolean,
    val data: MovieGenres?,
    val relatedMovies: List<MovieModel>?,
    val error: String,
){
    fun toUiState() = MovieGenresDetailScreenState(isLoading, data,relatedMovies, error)
}

data class MovieGenresDetailModelState(
    val isLoading: Boolean = false,
    val data: MovieGenres? = null,
    val relatedMovies: List<MovieModel>? = emptyList(),
    val error: String = "",
) {
    fun toUiState() = MovieGenresDetailModelState(isLoading, data,relatedMovies, error)
}