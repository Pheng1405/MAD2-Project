package com.example.gymapp.screens.MovieDetail

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.gymapp.components.RecommendMoviesSection
import com.example.gymapp.components.VideoPlayer
import com.example.gymapp.domain.model.MovieModel
import com.example.gymapp.util.Constants

@ExperimentalMaterial3Api
@Composable
fun MovieDetailScreen(id: String, navController: NavController,  movieDetailViewModel: MovieDetailViewModel = hiltViewModel(),) {
        val movieList = listOf(
            MovieModel("1", "Wanda Vision", "Action", "https://www.movieposters.com/cdn/shop/products/wandavision.R85648_480x.progressive.jpg?v=1673638271", "https://www.movieposters.com/cdn/shop/products/wandavision.R85648_480x.progressive.jpg?v=1673638271", 4.5, ""),
            MovieModel("2","The Flash", "Action",  "https://www.movieposters.com/cdn/shop/products/965a99756171f61611b6d6667b9f4004_480x.progressive.jpg?v=1573572622","https://www.movieposters.com/cdn/shop/products/wandavision.R85648_480x.progressive.jpg?v=1673638271", 4.5, ""),
            MovieModel("1", "Loki", "Action",  "https://www.movieposters.com/cdn/shop/products/54362_2_480x.progressive.png.jpg?v=1634831916","https://www.movieposters.com/cdn/shop/products/wandavision.R85648_480x.progressive.jpg?v=1673638271", 4.5, "",)
        )
        // Fetch the data when the composable enters the composition or when 'id' changes
        LaunchedEffect(id) {
            movieDetailViewModel.loadMovieData(id)
        }


        // Observe the LiveData or StateFlow from ViewModel
        val state by movieDetailViewModel.uiState.collectAsState()
        val movieDetail = state.data;

        val activity = LocalContext.current as Activity
        val showVideoPlayer = remember { mutableStateOf(false) }


        LazyColumn(modifier = Modifier.fillMaxSize()) {

            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                ) {
                    if (!showVideoPlayer.value) {
                        Image(
                            painter = rememberImagePainter(Constants.IMAGE_BASE_URL + movieDetail?.thumbnail),
                            contentDescription = "Movie Poster",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                        IconButton(
                            onClick = { showVideoPlayer.value = true },
                            modifier = Modifier
                                .align(Alignment.Center)
                                .size(48.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.PlayArrow,
                                contentDescription = "Play",
                                tint = Color.White,
                                modifier = Modifier.size(48.dp)
                            )
                        }
                    } else {
                        VideoPlayer(url = Constants.VIDEO_BASE_URL + movieDetail?.link, activity = activity)
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    movieDetail?.title?.let {
                        Text(
                            text = it,
                            style = TextStyle(fontSize = 24.sp, color = Color.Black)
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    IconButton(onClick = { /* TODO: Handle favorite */ }) {
                        Icon(Icons.Default.Favorite, contentDescription = "Like")
                    }
                    IconButton(onClick = { /* TODO: Handle share */ }) {
                        Icon(Icons.Default.Share, contentDescription = "Share")
                    }
                }

                // Movie description
                movieDetail?.description?.let {
                    Text(
                        text = it,
                        modifier = Modifier.padding(16.dp),
                        color = Color.Gray
                    )
                }

                // Recommended section
                Text(
                    text = "Recommended",
                    modifier = Modifier.padding(10.dp),
                    style = TextStyle(fontSize = 18.sp, color = Color.White)
                )
                RecommendMoviesSection(movieList, onSeeAllClicked = {}, navController)

            }
        }
}