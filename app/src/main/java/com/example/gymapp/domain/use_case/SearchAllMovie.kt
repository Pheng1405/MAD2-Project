package com.example.gymapp.domain.use_case

import com.example.gymapp.domain.MovieRepository


class SearchAllMovie(private val repository: MovieRepository) {
    suspend operator fun invoke(params : String) = repository.SearchAllMovie(params)
}