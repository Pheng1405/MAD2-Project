package com.example.gymapp.screens.MovieGenresDetail

import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.gymapp.domain.model.MovieGenres
import com.example.gymapp.screens.MovieGenres.MovieGenresViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun MovieGenresDetailScreen (
    genresId : String,
    navController: NavHostController,
    movieGenresDetailViewModel: MovieGenresDetailViewModel = hiltViewModel(),
    ){
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(
        color = Color.Transparent,
        darkIcons = true
    )

    // Fetch the data when the composable enters the composition or when 'id' changes
    LaunchedEffect(genresId) {
        movieGenresDetailViewModel.loadGenreData(genresId)
    }

    // Observe the LiveData or StateFlow from ViewModel
    val state by movieGenresDetailViewModel.uiState.collectAsState()
    val genresDetail = state.data;

    Log.i("Genres Detail}", genresDetail.toString())
    if (genresDetail != null) {
        Text(text = genresDetail.name)
    }
    else{
        Text("Genres detail = null")
    }
}