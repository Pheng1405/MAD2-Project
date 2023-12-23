package com.example.gymapp.domain.use_case

import com.example.gymapp.domain.MovieRepository

class GetAllMovieUseCase(private val repository: MovieRepository) {
    suspend operator fun invoke() = repository.getAllMovie()
}