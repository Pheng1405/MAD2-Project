package com.example.gymapp.data.remote
import com.example.gymapp.domain.model.AllMovieGenres
import com.example.gymapp.domain.model.AllMovieModel
import com.example.gymapp.domain.model.MovieDto
import com.example.gymapp.domain.model.MovieGenresDto
import com.example.gymapp.domain.model.MovieModel
import com.example.gymapp.domain.model.SignInDto
import com.example.gymapp.domain.model.SignInResponseDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

interface MovieGenresApi{
    @GET("/video-category/all")
    suspend fun getAllMovieGenres(): AllMovieGenres

    @GET("/video-category/one/{id}")
    suspend fun getOneMovieGenres(@Path("id") id: String): MovieGenresDto


    @POST("/users/login-with-password")
    @Headers("Content-Type: application/json")
    suspend fun siginIn(@Body() signInDto  : SignInDto): SignInResponseDto

    @GET("/video/all-no-auth")
    suspend fun getAllMovies(): AllMovieModel

    @GET("/video/one-guest/{id}")
    suspend fun getOneMovie(@Path("id") id: String): MovieDto
}