package com.example.gymapp.navigator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.gymapp.screens.Home.HomeScreen
import com.example.gymapp.screens.Movie.MovieScreen
import com.example.gymapp.screens.MovieDetail.MovieDetailScreen
import com.example.gymapp.screens.MovieGenres.MovieGenresScreen
import com.example.gymapp.screens.MovieGenresDetail.MovieGenresDetailScreen
import com.example.gymapp.screens.SignInScreen
import com.example.gymapp.screens.SignUpScreen
import com.example.gymapp.screens.TermsAndConditionsScreen
import com.example.gymapp.ui.theme.Primary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigationBar() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Primary),
        bottomBar = {
            NavigationBar {
                BottomNavigationItem().bottomNavigationItems().forEachIndexed { _, navigationItem ->
                    NavigationBarItem(
                        selected = navigationItem.route == currentDestination?.route,
                        label = {
                            Text(navigationItem.label)
                        },
                        icon = {
                            Icon(
                                navigationItem.icon,
                                contentDescription = navigationItem.label
                            )
                        },
                        onClick = {
                            navController.navigate(navigationItem.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) {paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screen.HomeScreen.route,
            modifier = Modifier.padding(paddingValues = paddingValues)) {
            composable(Screen.HomeScreen.route) {
                HomeScreen(
                    navController = navController
                )
            }
            composable(Screen.SignUpScreen.route) {
                SignUpScreen(
                    navController = navController
                )
            }
            composable(Screen.SignInScreen.route) {
                SignInScreen(
                    navController = navController
                )
            }

            composable(Screen.TermsAndConditionsScreen.route) {
                TermsAndConditionsScreen(
                    navController = navController
                )
            }

            composable(Screen.Genres.route) {
                MovieGenresScreen(
                    navController = navController
                )
            }

            composable("${Screen.GenresDetail.route}/{id}") { backStackEntry ->
                val id = backStackEntry.arguments?.getString("id")
                if (id != null) {
                    MovieGenresDetailScreen(
                        id,
                        navController = navController,
                    )
                }
            }

//            composable("${Screen.MovieDetail.route}") { backStackEntry ->
////                val id = backStackEntry.arguments?.getString("id")
//                MovieDetailScreen(
//                    navController = navController,
//                )
//            }

            composable(Screen.Movies.route) {
                MovieScreen(
                    navController = navController
                )
            }

            composable(Screen.MovieDetail.route) { backStackEntry ->
                val id = backStackEntry.arguments?.getString("id")
                if (id != null) {
                    MovieDetailScreen(
                        id,
                        navController = navController,
                    )
                }
            }

        }
    }
}