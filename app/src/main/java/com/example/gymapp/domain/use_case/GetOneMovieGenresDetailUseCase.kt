package com.example.gymapp.domain.use_case

import com.example.gymapp.domain.MovieRepository


class GetOneMovieGenresUseCase(private val repository: MovieRepository) {
    suspend operator fun invoke(genresId: String) = repository.getOneMovieGenresById(genresId)
}