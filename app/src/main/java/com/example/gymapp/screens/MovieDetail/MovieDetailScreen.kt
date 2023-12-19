package com.example.gymapp.screens.MovieDetail

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.gymapp.components.recommendations

@ExperimentalMaterial3Api
@Composable
fun MovieDetailScreen(navController: NavController) {
        Column(modifier = Modifier.fillMaxSize()) {
            TopAppBar(
                title = { Text("Movie Details") },
                modifier = Modifier.background(color = Color.Black),

                )

            // Movie poster and play button
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(250.dp)
//            ) {
//                Image(
//                    painter = rememberImagePainter("https://wallpapers.com/images/featured-full/avengers-vm16xv4a69smdauy.jpg"),
//                    contentDescription = "Movie Poster",
//                    modifier = Modifier.fillMaxSize(),
//                    contentScale = ContentScale.Crop
//                )
//                IconButton(
//                    onClick = { /* TODO: Handle play movie */ },
//                    modifier = Modifier
//                        .align(Alignment.Center)
//                        .size(48.dp)
//                ) {
//                    Icon(
//                        imageVector = Icons.Default.PlayArrow,
//                        contentDescription = "Play",
//                        tint = Color.White,
//                        modifier = Modifier.size(48.dp)
//                    )
//                }
//            }

            // Movie title and actions
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Doctor Strange 2",
                    style = TextStyle(fontSize = 24.sp, color = Color.White)
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
                text = "This is the sample description of the movie...",
                modifier = Modifier.padding(16.dp),
                color = Color.Gray
            )

            // Recommended section
            Text(
                text = "Recommended",
                modifier = Modifier.padding(16.dp),
                style = TextStyle(fontSize = 18.sp, color = Color.White)
            )
            LazyRow {
                items(recommendations) { recommendation ->
                    Card(
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier
                            .padding(8.dp)
                            .size(120.dp, 180.dp)
                    ) {
                        Image(
                            painter = rememberImagePainter(recommendation.imageRes),
                            contentDescription = "Recommended Movie",
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }
        }
}