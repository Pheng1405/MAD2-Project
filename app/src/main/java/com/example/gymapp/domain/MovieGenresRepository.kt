package com.example.gymapp.domain


import com.example.gymapp.domain.model.AllMovieGenres
import com.example.gymapp.util.Resource
import kotlinx.coroutines.flow.Flow

interface  MovieGenresRepository {
    suspend fun getAllMovieGenres(): Flow<Resource<AllMovieGenres>>
}