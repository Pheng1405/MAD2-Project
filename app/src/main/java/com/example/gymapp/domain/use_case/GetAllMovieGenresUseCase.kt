package com.example.gymapp.domain.use_case

import com.example.gymapp.domain.MovieGenresRepository


class GetAllMovieGenresUseCase(private val repository: MovieGenresRepository) {
    suspend operator fun invoke() = repository.getAllMovieGenres()
}