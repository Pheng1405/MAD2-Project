package com.example.gymapp.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.gymapp.R
import com.example.gymapp.components.AppToolbar
import com.example.gymapp.components.GreetingSection
import com.example.gymapp.components.SearchBar
import com.example.gymapp.components.UpcomingMoviesComponent
import com.example.gymapp.data.home.HomeViewModel


@Composable
fun HomeScreen(homeViewModel: HomeViewModel = viewModel(), navController: NavController) {

    val posterUrls = listOf(
        "https://www.khmertimeskh.com/wp-content/uploads/2019/05/AVENGERS-1.jpg",
        "https://static.republika.co.id/uploads/images/inpicture_slide/zombie_220914154715-752.jpeg",
        // Add as many URLs as needed
    )
    Column {
        Row {
            GreetingSection()
        }
        Row {
            SearchBar()
        }

        Row {
            UpcomingMoviesComponent(posterUrls, onSeeAllClicked = { Log.i("Hi", "Hi")}, onMoviePosterClicked = { index ->
                // Handle movie poster click, `index` is the index of the clicked poster
            } )
        }
    }

}