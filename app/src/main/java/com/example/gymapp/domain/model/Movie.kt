package com.example.gymapp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class CategoryModel(
    val id : String,
    val category_id : String
)

@Serializable
data  class MovieModel (
    val id : String,
    val title : String,
    val description : String,
    val thumbnail : String,
    val land_thumbnail : String,
    val rating : Double,
    val link : String,
    val categories : List<CategoryModel>,
)

@Serializable
data  class MovieDto (
    val data : MovieModel,
)

@Serializable
data class AllMovieModel(
    val data : List<MovieModel>,
)

