package com.example.gymapp.screens.MovieGenresDetail

import android.app.Activity
import android.util.Log
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
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.example.gymapp.components.RecommendMoviesSection
import com.example.gymapp.components.VideoPlayer
import com.example.gymapp.domain.model.MovieGenres
import com.example.gymapp.domain.model.MovieModel
import com.example.gymapp.screens.MovieGenres.MovieGenresViewModel
import com.example.gymapp.util.Constants
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




    LazyColumn(modifier = Modifier.fillMaxSize()) {

        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            ) {
                Image(
                    painter = rememberImagePainter(Constants.IMAGE_BASE_URL + genresDetail?.thumbnail),
                    contentDescription = "Movie Poster",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                genresDetail?.name?.let {
                    Text(
                        text = it,
                        style = TextStyle(fontSize = 24.sp, color = Color.Black)
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
            }

            // Movie description
            genresDetail?.description?.let {
                Text(
                    text = it,
                    modifier = Modifier.padding(16.dp),
                    color = Color.Gray
                )
            }

            // Recommended section
//            Text(
//                text = "Recommended",
//                modifier = Modifier.padding(10.dp),
//                style = TextStyle(fontSize = 18.sp, color = Color.White)
//            )
//            RecommendMoviesSection(movieList, onSeeAllClicked = {})

        }
    }
}