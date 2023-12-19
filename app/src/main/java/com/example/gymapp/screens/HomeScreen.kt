package com.example.gymapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.gymapp.components.GreetingSection
import com.example.gymapp.components.NewMoviesSection
import com.example.gymapp.components.SearchBar
import com.example.gymapp.components.UpcomingMoviesComponent
import com.example.gymapp.data.home.HomeViewModel
import com.example.gymapp.domain.model.MovieModel
import com.example.gymapp.navigator.Screen


@Composable
fun HomeScreen(homeViewModel: HomeViewModel = viewModel(), navController: NavController) {

    val posterUrls = listOf(
        "https://www.khmertimeskh.com/wp-content/uploads/2019/05/AVENGERS-1.jpg",
        "https://static.republika.co.id/uploads/images/inpicture_slide/zombie_220914154715-752.jpeg",
        // Add as many URLs as needed
    )


    val movieList = listOf(
        MovieModel("1", "Wanda Vision", "Action", 4.5, "https://www.movieposters.com/cdn/shop/products/wandavision.R85648_480x.progressive.jpg?v=1673638271"),
        MovieModel("2","The Flash", "Action", 4.5, "https://www.movieposters.com/cdn/shop/products/965a99756171f61611b6d6667b9f4004_480x.progressive.jpg?v=1573572622"),
        MovieModel("1", "Loki", "Action", 4.5, "https://www.movieposters.com/cdn/shop/products/54362_2_480x.progressive.png.jpg?v=1634831916"),
    )

    Column {
        GreetingSection()
        SearchBar()
        LazyColumn {
            item {
                UpcomingMoviesComponent(
                    posterUrls,
                    onSeeAllClicked = { /* Handle See All click */ },
                    onMoviePosterClicked = { index ->
                        navController.navigate(Screen.MovieDetail.route)
                    }
                )
            }
            item{
                NewMoviesSection(movieList, onSeeAllClicked = { /* Handle See All click */ })
            }
        }
    }

}