package com.example.gymapp.screens.Home

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
import com.example.gymapp.components.NewMoviesSection
import com.example.gymapp.components.SearchBar
import com.example.gymapp.components.SuggestMoviesSection
import com.example.gymapp.domain.model.MovieModel
import com.example.gymapp.navigator.Screen
import com.google.accompanist.systemuicontroller.rememberSystemUiController


@Composable
fun HomeScreen(
    navController: NavHostController,
    homeScreenViewModel: HomeScreenViewModel = hiltViewModel(),
) {
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(
        color = Color.Transparent,
        darkIcons = true
    )

    val state by homeScreenViewModel.uiState.collectAsState()
    val new_movie : List<MovieModel>? = state.movie;

    Column (
        modifier = Modifier.background(color = Color.Black)
    ) {
        GreetingSection()
        SearchBar(hint = "What to watch?", onSearchQueryChanged = {})
        LazyColumn {
            item{
                if (new_movie != null) {
                    NewMoviesSection(new_movie, onSeeAllClicked = { navController.navigate(Screen.Movies.route) }, navController = navController)
                }
            }
            item{
                if (new_movie != null) {
                    SuggestMoviesSection(new_movie, onSeeAllClicked = { navController.navigate(Screen.Movies.route) }, navController = navController)
                }
            }
        }
    }
}
