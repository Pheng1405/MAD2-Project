package com.example.gymapp.screens.MovieDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gymapp.domain.use_case.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val useCases: UseCases,
) : ViewModel() {

    private val viewModelState = MutableStateFlow(MovieDetailModelState())
    val uiState = viewModelState
        .map { it.toUiState() }
        .stateIn(
            viewModelScope,
            SharingStarted.Eagerly,
            viewModelState.value.toUiState()
        )

    init {
        getOneMovieDetail()
    }

    private fun getOneMovieDetail() {
        viewModelScope.launch {
            useCases.getOneMovieGenresUseCase("").onEach { result ->
//                viewModelState.update { state ->
//                    when (result) {
//                        is Resource.Success -> state.copy(data = result.data.,
//                            isLoading = false,
//                            error = "")
//                        is Resource.Error -> state.copy(error = result.message
//                            ?: "An error occurred", data = emptyList(), isLoading = false)
//                        is Resource.Loading -> state.copy(isLoading = true, error = "")
//                    }
//                }
            }.launchIn(this)
        }
    }
}