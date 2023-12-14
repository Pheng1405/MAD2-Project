package com.example.gymapp.data.remote
import com.example.gymapp.domain.model.AllMovieGenres
import com.example.gymapp.domain.model.MovieGenres
import com.example.gymapp.domain.model.MovieGenresDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface MovieGenresApi{
    @GET("/video-category/all")
    suspend fun getAllMovieGenres(): AllMovieGenres

    @GET("/video-category/one/{id}")
    suspend fun getOneMovieGenres(@Path("id") id: String): MovieGenresDto
}