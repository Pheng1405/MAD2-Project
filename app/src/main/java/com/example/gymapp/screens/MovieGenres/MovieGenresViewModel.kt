package com.example.gymapp.screens.MovieGenres

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gymapp.domain.model.AllMovieGenres
import com.example.gymapp.domain.use_case.UseCases
import com.example.gymapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieGenresViewModel @Inject constructor(
    private val useCases: UseCases,
) : ViewModel() {

    private val viewModelState = MutableStateFlow(MovieGenresModelState())
    val uiState = viewModelState
        .map { it.toUiState() }
        .stateIn(
            viewModelScope,
            SharingStarted.Eagerly,
            viewModelState.value.toUiState()
        )

    init {
        getAllMovieGenres()
    }

    private fun getAllMovieGenres() {
        viewModelScope.launch {
            useCases.getAllMovieGenresUseCase().onEach { result ->
                viewModelState.update { state ->
                    when (result) {
                        is Resource.Success -> {
                            Log.d("tag", result.data!!.data.toString());
                            Log.i(result.data!!.data[0].name, "sucess")
                            state.copy(
                                category = result.data?.data,
                                isLoading = false,
                                error = "")
                        }
                        is Resource.Error -> {
                            println(result)
                            state.copy(error = result.message
                                ?: "An error occurred", category = emptyList(), isLoading = false)
                        }
                        is Resource.Loading -> {
                            state.copy(isLoading = true, error = "")
                        }
                    }
                }
            }.launchIn(this)
        }
    }
}