package com.example.gymapp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data  class MovieModel (
    val id : String,
    val title : String,
    val description : String,
    val thumbnail : String,
    val land_thumbnail : String,
    val rating : Double,
)

//@Serializable
//data class MovieModel(
//    val id : String,
//    val title: String,
//    val genre: String,
//    val rating: Double,
//    val imageUrl: String
//)

@Serializable
data class AllMovieModel(
    val data : List<MovieModel>,
)