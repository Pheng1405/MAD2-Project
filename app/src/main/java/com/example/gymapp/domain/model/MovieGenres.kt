package com.example.gymapp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data  class MovieGenres (
    val id : String,
    val name : String,
)

@Serializable
data class AllMovieGenres(
    val data: List<MovieGenres>,
)