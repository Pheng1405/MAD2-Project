package com.example.gymapp.screens.MovieDetail

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gymapp.domain.use_case.UseCases
import com.example.gymapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
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

    fun loadMovieData(id: String) {
        getOneMovieDetail(id)
    }

    fun loadRelatedMovie(category_id : String){
        getRelatedMovie(category_id)
    }

    private fun getOneMovieDetail(id : String) {
        viewModelScope.launch {
            useCases.getOneMovieUseCase(id).collect { result ->
                viewModelState.update { state ->
                    result.also { println(it) }
                    when (result) {
                        is Resource.Success -> {
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

    private fun getRelatedMovie(category_id: String){
        viewModelScope.launch {
            useCases.searchAllMovie(category_id, "").collect  { result ->
                viewModelState.update { state ->
                    result.also { println(it) }
                    when (result) {
                        is Resource.Success ->{
                            state.copy(
                                relatedMovies = result.data?.data,
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