package com.example.gymapp.navigator

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowUp
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
                label = "Sign Up",
                icon = Icons.Filled.Search,
                route = Screen.SignUpScreen.route
            ),
            BottomNavigationItem(
                label = "Sign In",
                icon = Icons.Filled.KeyboardArrowUp,
                route = Screen.SignInScreen.route
            ),

            BottomNavigationItem(
                label = "Test",
                icon = Icons.Filled.AccountCircle,
                route = Screen.Test.route
            ),

            BottomNavigationItem(
                label = "Test",
                icon = Icons.Filled.AccountCircle,
                route = Screen.TermsAndConditionsScreen.route
            ),
        )
    }
}
