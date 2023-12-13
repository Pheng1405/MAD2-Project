package com.example.gymapp.domain.use_case

import com.example.gymapp.domain.MovieRepository

class GetOneMovieUseCase(private val repository: MovieRepository) {
    suspend operator fun invoke(id: String) = repository.getOneMovieGenresById(id)
}