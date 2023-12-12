package com.example.gymapp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data  class MovieModel (
    val id : String,
    val title : String,
    val description : String,
    val thumbnail : String,
    val category_id : String,
)