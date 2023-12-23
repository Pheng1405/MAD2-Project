package com.example.gymapp.screens.MovieGenresDetail

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gymapp.data.remote.MovieGenresApi
import com.example.gymapp.domain.model.MovieGenres
import com.example.gymapp.domain.use_case.UseCases
import com.example.gymapp.screens.MovieGenres.MovieGenresModelState
import com.example.gymapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

@HiltViewModel
class MovieGenresDetailViewModel @Inject constructor(
    private val useCases: UseCases,
) : ViewModel() {

    private val viewModelState = MutableStateFlow(MovieGenresDetailModelState())
    val uiState = viewModelState
        .map { it.toUiState() }
        .stateIn(
            viewModelScope,
            SharingStarted.Eagerly,
            viewModelState.value.toUiState()
        )

    fun loadGenreData(id: String) {
        getMovieGenresById(id)
    }

    // if use retrofit use suspend private suspend fun getMovieGenresById
    private fun getMovieGenresById(id: String) {
        viewModelScope.launch {
            useCases.getOneMovieGenresUseCase(id).collect  { result ->
                viewModelState.update { state ->
                    result.also { println(it) }
                    when (result) {
                        is Resource.Success ->{
                            state.copy(
                                data = result.data?.data,
                                isLoading = false,
                                error = ""
                            )
                        }
                        is Resource.Error -> {
                            Log.d("tag", result.data.toString());
                            state.copy(
                                error = result.message ?: "An error occurred",
                                data = null,
                                isLoading = false
                            )
                        }
                        is Resource.Loading -> state.copy(
                            isLoading = true,
                            error = ""
                        )
                    }
                }
            }
        }
    }
}
