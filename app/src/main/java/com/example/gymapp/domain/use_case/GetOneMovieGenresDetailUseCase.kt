package com.example.gymapp.domain.use_case

import com.example.gymapp.domain.MovieRepository
import com.example.gymapp.domain.model.MovieGenres
import com.example.gymapp.domain.model.MovieModel
import com.example.gymapp.util.Resource
import kotlinx.coroutines.flow.Flow

class GetOneMovieGenresUseCase(private val repository: MovieRepository) {
    suspend operator fun invoke(genresId: String) = repository.getOneMovieGenresById(genresId)
}