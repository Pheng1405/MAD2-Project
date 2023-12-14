package com.example.gymapp.screens.MovieGenres

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.gymapp.components.MovieGenresContainer
import com.example.gymapp.domain.model.MovieGenres
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun MovieGenresScreen(
    navController: NavHostController,
    movieGenresViewModel: MovieGenresViewModel = hiltViewModel(),
) {
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(
        color = Color.Transparent,
        darkIcons = true
    )

    val state by movieGenresViewModel.uiState.collectAsState()
    val categories = ArrayList<MovieGenres>()
    state.category?.forEach { item ->
        categories.add(item)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
//        SearchTextField(searchItem = searchItem, changeEvent = { searchItem = it })
        Box(

        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp)
                    .fillMaxHeight(0.9f)
            ) {
                if (state.category?.isNotEmpty() == true) {
                    categories.toSet().forEach { category ->
                        item {
                            state.category?.let {
                                MovieGenresContainer(
                                    category,
                                    navController
                                )
                            }
                        }
                    }
                }
            }
            if (state.error.isNotBlank()) {
                Text(
                    text = state.error,
                    color = Color.Red,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)
                )
            }
            if (state.isLoading) {
                CircularProgressIndicator(modifier = Modifier
                    .align(Alignment.Center)
                    .padding(32.dp))
            }
        }

    }
}