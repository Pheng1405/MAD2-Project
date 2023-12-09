package com.example.gymapp.data.remote
import com.example.gymapp.domain.model.AllMovieGenres
import com.example.gymapp.domain.model.MovieGenres
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
interface MovieGenresApi{
    @GET("/video-category/all")
    suspend fun getAllMovieGenres(): AllMovieGenres
}