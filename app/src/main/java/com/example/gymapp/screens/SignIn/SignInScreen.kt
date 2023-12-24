package com.example.gymapp.screens.SignIn

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.gymapp.R
import com.example.gymapp.components.ButtonComponent
import com.example.gymapp.components.ClickableLoginTextComponent
import com.example.gymapp.components.DividerTextComponent
import com.example.gymapp.components.ErrorDialog
import com.example.gymapp.components.HeadingTextComponent
import com.example.gymapp.components.MyTextFieldComponent
import com.example.gymapp.components.NormalTextComponent
import com.example.gymapp.components.PasswordTextFieldComponent
import com.example.gymapp.components.UnderLinedTextComponent
import com.example.gymapp.navigator.Screen

@Composable
fun SignInScreen(loginViewModel: LoginViewModel = viewModel(), navController: NavController) {


    val loginError by loginViewModel.loginError.observeAsState()

//    private val viewModel: MainViewModel by viewModels()


    loginError?.let {
        ErrorDialog(errorMessage = it) {
            loginViewModel.loginError.value = null // Reset error after displaying
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(28.dp)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
            ) {

                NormalTextComponent(value = stringResource(id = R.string.login))
                HeadingTextComponent(value = stringResource(id = R.string.welcome))
                Spacer(modifier = Modifier.height(20.dp))

                MyTextFieldComponent(labelValue = stringResource(id = R.string.email),
                    painterResource(id = R.drawable.baseline_textsms_24),
                    onTextChanged = {
                        loginViewModel.onEvent(LoginUIEvent.EmailChanged(it))
                    },
                    errorStatus = loginViewModel.loginUIState.value.emailError
                )

                PasswordTextFieldComponent(
                    labelValue = stringResource(id = R.string.password),
                    painterResource(id = R.drawable.baseline_vpn_key_24),
                    onTextSelected = {
                        loginViewModel.onEvent(LoginUIEvent.PasswordChanged(it))
                    },
                    errorStatus = loginViewModel.loginUIState.value.passwordError
                )

                Spacer(modifier = Modifier.height(40.dp))
                UnderLinedTextComponent(value = stringResource(id = R.string.forgot_password))

                Spacer(modifier = Modifier.height(40.dp))

                ButtonComponent(
                    value = stringResource(id = R.string.login),
                    onButtonClicked = {
                        loginViewModel.onEvent(LoginUIEvent.LoginButtonClicked)
                    },
                    isEnabled = loginViewModel.allValidationsPassed.value
                )

                Spacer(modifier = Modifier.height(20.dp))

                DividerTextComponent()
                ClickableLoginTextComponent(tryingToLogin = false, onTextSelected = {
                    navController.navigate(Screen.SignUpScreen.route)
                })
            }
        }
    }
}