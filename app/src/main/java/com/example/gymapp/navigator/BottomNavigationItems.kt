package com.example.gymapp.navigator

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationItem(
    val label : String = "",
    val icon : ImageVector = Icons.Filled.Home,
    val route : String = ""
) {
    fun bottomNavigationItems() : List<BottomNavigationItem> {
        return listOf(
            BottomNavigationItem(
                label = "Home",
                icon = Icons.Filled.Home,
                route = Screen.HomeScreen.route
            ),

            BottomNavigationItem(
                label = "Movie Screen",
                icon = Icons.Filled.PlayArrow,
                route = Screen.MovieDetail.route
            ),


            BottomNavigationItem(
                label = "Genres",
                icon = Icons.Filled.List,
                route = Screen.Genres.route
            ),


            BottomNavigationItem(
                label = "Profile",
                icon = Icons.Filled.AccountCircle,
                route = Screen.SignUpScreen.route
            ),
        )
    }
}
