package com.example.gymapp.screens.SignIn
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
//import com.example.gymapp.auth.TokenManager
import com.example.gymapp.data.remote.MovieGenresApi
import com.example.gymapp.domain.model.SignInDto
import com.example.gymapp.rules.Validator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
//    private val tokenManager: TokenManager
) : ViewModel() {

    var loginUIState = mutableStateOf(LoginUIState())

    var allValidationsPassed = mutableStateOf(false)

    var loginInProgress = mutableStateOf(false)


    var loginError = MutableLiveData<String?>()


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

        viewModelScope.launch {

            try {
                val result = service.siginIn(signInDto)
                loginInProgress.value = false
            } catch (e: Exception) {
                loginError.value = "Login failed: Invalid email or password"
                println("Error: ${e.message}")
        }

        }
    }

}