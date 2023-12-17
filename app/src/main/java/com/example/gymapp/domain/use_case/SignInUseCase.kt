package com.example.gymapp.domain.use_case

import com.example.gymapp.domain.MovieRepository
import com.example.gymapp.domain.model.SignInDto

class SignInUseCase(private val repository: MovieRepository)
{
    suspend operator fun invoke(signInDto: SignInDto) = repository.signIn(signInDto)
}