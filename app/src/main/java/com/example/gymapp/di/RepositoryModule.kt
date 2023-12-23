package com.example.gymapp.di

import com.example.gymapp.data.remote.MovieGenresApi
import com.example.gymapp.data.repository.MovieRepositoryImpl
import com.example.gymapp.domain.MovieRepository
import com.example.gymapp.domain.use_case.GetAllMovieGenresUseCase
import com.example.gymapp.domain.use_case.GetAllMovieUseCase
import com.example.gymapp.domain.use_case.GetOneMovieGenresUseCase
import com.example.gymapp.domain.use_case.SignInUseCase
import com.example.gymapp.domain.use_case.UseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(movieGenresApi: MovieGenresApi): MovieRepository {
        return MovieRepositoryImpl(movieGenresApi)
    }

    @Provides
    @Singleton
    fun provideUseCases(repository: MovieRepository): UseCases =
        UseCases(
            getAllMovieGenresUseCase = GetAllMovieGenresUseCase(repository = repository),
            getOneMovieGenresUseCase = GetOneMovieGenresUseCase(repository = repository),
            signInUseCase = SignInUseCase(repository = repository),
            getAllMovieUseCase = GetAllMovieUseCase(repository = repository)
        )
}