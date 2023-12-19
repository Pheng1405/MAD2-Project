package com.example.gymapp.screens.MovieDetail

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.gymapp.components.NewMoviesSection
import com.example.gymapp.components.RecommendMoviesSection
import com.example.gymapp.components.VideoPlayer
import com.example.gymapp.components.recommendations
import com.example.gymapp.domain.model.MovieModel

@ExperimentalMaterial3Api
@Composable
fun MovieDetailScreen(navController: NavController) {
        val movieList = listOf(
            MovieModel("1", "Wanda Vision", "Action", 4.5, "https://www.movieposters.com/cdn/shop/products/wandavision.R85648_480x.progressive.jpg?v=1673638271"),
            MovieModel("2","The Flash", "Action", 4.5, "https://www.movieposters.com/cdn/shop/products/965a99756171f61611b6d6667b9f4004_480x.progressive.jpg?v=1573572622"),
            MovieModel("1", "Loki", "Action", 4.5, "https://www.movieposters.com/cdn/shop/products/54362_2_480x.progressive.png.jpg?v=1634831916"),
        )
        val activity = LocalContext.current as Activity
        Column(modifier = Modifier.fillMaxSize()) {
            val showVideoPlayer = remember { mutableStateOf(false) }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            ) {
                if (!showVideoPlayer.value) {
                    Image(
                        painter = rememberImagePainter("https://wallpapers.com/images/featured-full/avengers-vm16xv4a69smdauy.jpg"),
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
                    VideoPlayer(url = "https://cph-p2p-msl.akamaized.net/hls/live/2000341/test/master.m3u8", activity = activity)
                }
            }
                

            // Movie title and actions
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Doctor Strange 2",
                    style = TextStyle(fontSize = 24.sp, color = Color.Black)
                )
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = { /* TODO: Handle favorite */ }) {
                    Icon(Icons.Default.Favorite, contentDescription = "Like")
                }
                IconButton(onClick = { /* TODO: Handle share */ }) {
                    Icon(Icons.Default.Share, contentDescription = "Share")
                }
            }

            // Movie description
            Text(
                text = "Strange was a skilled neurosurgeon before nerve damage impaired his hands. Doctor Strange is described as \"the mightiest magician in the cosmos\" and \"more powerful by far than any of your fellow humanoids\" by Eternity, the sentience of the Marvel Universe.",
                modifier = Modifier.padding(16.dp),
                color = Color.Gray
            )

            // Recommended section
            Text(
                text = "Recommended",
                modifier = Modifier.padding(10.dp),
                style = TextStyle(fontSize = 18.sp, color = Color.White)
            )
            LazyColumn{
                item{
                    RecommendMoviesSection(movieList, onSeeAllClicked = {})
                }
            }
        }
}