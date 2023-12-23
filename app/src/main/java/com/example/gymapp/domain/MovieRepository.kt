package com.example.gymapp.domain


import com.example.gymapp.domain.model.AllMovieGenres
import com.example.gymapp.domain.model.AllMovieModel
import com.example.gymapp.domain.model.MovieGenres
import com.example.gymapp.domain.model.MovieGenresDto
import com.example.gymapp.domain.model.MovieModel
import com.example.gymapp.domain.model.MovieModelDto
import com.example.gymapp.domain.model.SignInDto
import com.example.gymapp.domain.model.SignInResponseDto
import com.example.gymapp.util.Resource
import kotlinx.coroutines.flow.Flow

interface  MovieRepository {
    suspend fun getAllMovieGenres(): Flow<Resource<AllMovieGenres>>
    suspend fun getOneMovieGenresById(id : String) : Flow<Resource<MovieGenresDto>>

    suspend fun signIn(signInDto: SignInDto) : Flow<Resource<SignInResponseDto>>

    suspend fun getAllMovie(): Flow<Resource<AllMovieModel>>

    suspend fun getOneMovieById(id : String) : Flow<Resource<MovieModelDto>>
}