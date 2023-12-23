package com.example.gymapp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data  class MovieGenres (
    val id : String,
    val name : String,
    val thumbnail : String,
    val description : String,
)


@Serializable
data  class MovieGenresDto (
    val data : MovieGenres,
)

@Serializable
data class AllMovieGenres(
    val data: List<MovieGenres>,
)