package com.example.gymapp.di

import com.example.gymapp.data.remote.MovieGenresApi
import com.example.gymapp.data.repository.MovieRepositoryImpl
import com.example.gymapp.domain.MovieGenresRepository
import com.example.gymapp.domain.model.MovieGenres
import com.example.gymapp.domain.use_case.GetAllMovieGenresUseCase
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
    fun provideMovieRepository(movieGenresApi: MovieGenresApi): MovieGenresRepository {
        return MovieRepositoryImpl(movieGenresApi)
    }

    @Provides
    @Singleton
    fun provideUseCases(repository: MovieGenresRepository): UseCases =
        UseCases(
            getAllMovieGenresUseCase = GetAllMovieGenresUseCase(repository = repository),
        )
}