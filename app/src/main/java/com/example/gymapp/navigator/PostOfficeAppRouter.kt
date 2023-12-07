package com.example.gymapp.navigator

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.gymapp.data.home.HomeViewModel

sealed class Screen(val route: String) {
    object SignUpScreen : Screen("sign_up")
    object TermsAndConditionsScreen : Screen("term_and_condition")
    object SignInScreen : Screen("sign_in")
    object HomeScreen : Screen("home_screen")
    object Test : Screen("test")
}


object PostOfficeAppRouter {

    var currentScreen: MutableState<Screen> = mutableStateOf(Screen.SignUpScreen)

    fun navigateTo(destination : Screen){
        currentScreen.value = destination
    }

}

@Composable
fun TestScreen(navController: NavController){
    Text(text = "Hello Test");
}