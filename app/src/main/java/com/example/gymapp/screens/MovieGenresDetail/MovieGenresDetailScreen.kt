package com.example.gymapp.screens.MovieGenresDetail

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
    navController: NavHostController,
    movieGenresDetailViewModel: MovieGenresDetailViewModel = hiltViewModel(),
    ){
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(
        color = Color.Transparent,
        darkIcons = true
    )

    val state by movieGenresDetailViewModel.uiState.collectAsState()
    val genresDetail = state.genres;

    if (genresDetail != null) {
        Text(text = genresDetail.name)
    }
}