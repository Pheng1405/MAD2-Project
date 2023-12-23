package com.example.gymapp.screens.Movie

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.gymapp.components.GreetingSection
import com.example.gymapp.components.MovieCardGrid
import com.example.gymapp.components.MovieScreenList
import com.example.gymapp.components.NewMoviesSection
import com.example.gymapp.components.SearchBar
import com.example.gymapp.domain.model.MovieModel
import com.example.gymapp.screens.Home.HomeScreenViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController


@Composable
fun MovieScreen(
    navController: NavHostController,
    movieScreenViewModel: MovieScreenViewModel = hiltViewModel(),
) {
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(
        color = Color.Transparent,
        darkIcons = true
    )

    val state by movieScreenViewModel.uiState.collectAsState()
    val new_movie : List<MovieModel>? = state.movie;

    Column(
        modifier = Modifier.background(color = Color.Black)
    ) {

        SearchBar()
        if (new_movie != null) {
            MovieCardGrid(new_movie, onSeeAllClicked = { /* Handle See All click */ })
        }
    }
}