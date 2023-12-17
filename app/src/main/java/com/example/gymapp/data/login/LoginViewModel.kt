package com.example.gymapp.data.login

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gymapp.data.remote.MovieGenresApi
import com.example.gymapp.domain.model.SignInDto
import com.example.gymapp.rules.Validator
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginViewModel : ViewModel() {
    var loginUIState = mutableStateOf(LoginUIState())

    var allValidationsPassed = mutableStateOf(false)

    var loginInProgress = mutableStateOf(false)


    fun onEvent(event: LoginUIEvent) {
        when (event) {
            is LoginUIEvent.EmailChanged -> {
                loginUIState.value = loginUIState.value.copy(
                    email = event.email
                )
            }

            is LoginUIEvent.PasswordChanged -> {
                loginUIState.value = loginUIState.value.copy(
                    password = event.password
                )
            }

            is LoginUIEvent.LoginButtonClicked -> {
                login()
            }
        }
        validateLoginUIDataWithRules()
    }

    private fun validateLoginUIDataWithRules() {
        val emailResult = Validator.validateEmail(
            email = loginUIState.value.email
        )


        val passwordResult = Validator.validatePassword(
            password = loginUIState.value.password
        )

        loginUIState.value = loginUIState.value.copy(
            emailError = emailResult.status,
            passwordError = passwordResult.status
        )

        allValidationsPassed.value = emailResult.status && passwordResult.status

    }

    private fun login() {

        loginInProgress.value = true
        val email = loginUIState.value.email
        val password = loginUIState.value.password
        val signInDto = SignInDto(email, password)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.mc-dragon.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(MovieGenresApi::class.java)

        Log.i("Click", "Clicked")
        viewModelScope.launch {
            Log.i("View Model Scope", "Clicked")

            try {
                val result = service.siginIn(signInDto)
                println("Data: $result")
                println("MovieGenres: ${result.data}")
                loginInProgress.value = false
            } catch (e: Exception) {
                println("Error: ${e.message}")
        }

        }
    }

}