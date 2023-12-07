package com.example.gymapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.gymapp.components.CheckboxComponent
import com.example.gymapp.components.ClickableLoginTextComponent
import com.example.gymapp.components.DividerTextComponent
import com.example.gymapp.components.HeadingTextComponent
import com.example.gymapp.components.MyTextFieldComponent
import com.example.gymapp.components.NormalTextComponent
import com.example.gymapp.components.PasswordTextFieldComponent
import com.example.gymapp.components.UnderLinedTextComponent
import com.example.gymapp.data.login.LoginUIEvent
import com.example.gymapp.data.login.LoginViewModel
import com.example.gymapp.data.signup.SignupUIEvent
import com.example.gymapp.data.signup.SignupViewModel
import com.example.gymapp.navigator.PostOfficeAppRouter
import com.example.gymapp.navigator.Screen

@Composable
fun SignInScreen(loginViewModel: LoginViewModel = viewModel(), navController: NavController) {

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
//            Text(text = "Login")

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
            ) {

                NormalTextComponent(value = stringResource(id = R.string.login))
                HeadingTextComponent(value = stringResource(id = R.string.welcome))
                Spacer(modifier = Modifier.height(20.dp))
//
                MyTextFieldComponent(labelValue = stringResource(id = R.string.email),
                    painterResource(id = R.drawable.baseline_textsms_24),
                    onTextChanged = {
                        loginViewModel.onEvent(LoginUIEvent.EmailChanged(it))
                    },
                    errorStatus = loginViewModel.loginUIState.value.emailError
                )
//
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
                    PostOfficeAppRouter.navigateTo(Screen.SignUpScreen)
                })
            }
        }

//        if(loginViewModel.loginInProgress.value) {
//            CircularProgressIndicator()
//        }
    }
    



//    SystemBackButtonHandler {
//        PostOfficeAppRouter.navigateTo(Screen.SignUpScreen)
//    }
}


//@Composable
//fun SignInScreen(signupViewModel: SignupViewModel = viewModel(), navController: NavController) {
//
//    Box(
//        modifier = Modifier.fillMaxSize().background(Color.White),
//        contentAlignment = Alignment.Center
//    ) {
//
//        Surface(
//            modifier = Modifier
//                .fillMaxSize()
//                .background(Color.White)
//                .padding(28.dp)
//        ) {
//            Column(modifier = Modifier.fillMaxSize().background(Color.White)) {
//
//                NormalTextComponent(value = stringResource(id = R.string.hello))
//                HeadingTextComponent(value = stringResource(id = R.string.create_account))
//                Spacer(modifier = Modifier.height(20.dp))
//
//                MyTextFieldComponent(
//                    labelValue = stringResource(id = R.string.first_name),
//                    painterResource(id = R.drawable.baseline_supervisor_account_24),
//                    onTextChanged = {
//                        signupViewModel.onEvent(SignupUIEvent.FirstNameChanged(it))
//                    },
//                    errorStatus = signupViewModel.registrationUIState.value.firstNameError
//                )
//
//                MyTextFieldComponent(
//                    labelValue = stringResource(id = R.string.last_name),
//                    painterResource = painterResource(id = R.drawable.baseline_supervisor_account_24),
//                    onTextChanged = {
//                        signupViewModel.onEvent(SignupUIEvent.LastNameChanged(it))
//                    },
//                    errorStatus = signupViewModel.registrationUIState.value.lastNameError
//                )
//
//                MyTextFieldComponent(
//                    labelValue = stringResource(id = R.string.email),
//                    painterResource = painterResource(id = R.drawable.baseline_textsms_24),
//                    onTextChanged = {
//                        signupViewModel.onEvent(SignupUIEvent.EmailChanged(it))
//                    },
//                    errorStatus = signupViewModel.registrationUIState.value.emailError
//                )
//
//                PasswordTextFieldComponent(
//                    labelValue = stringResource(id = R.string.password),
//                    painterResource = painterResource(id = R.drawable.baseline_vpn_key_24),
//                    onTextSelected = {
//                        signupViewModel.onEvent(SignupUIEvent.PasswordChanged(it))
//                    },
//                    errorStatus = signupViewModel.registrationUIState.value.passwordError
//                )
//
//                CheckboxComponent(value = stringResource(id = R.string.terms_and_conditions),
//                    onTextSelected = {
//                        PostOfficeAppRouter.navigateTo(Screen.TermsAndConditionsScreen)
//                    },
//                    onCheckedChange = {
//                        signupViewModel.onEvent(SignupUIEvent.PrivacyPolicyCheckBoxClicked(it))
//                    }
//                )
//
//                Spacer(modifier = Modifier.height(40.dp))
//
//                ButtonComponent(
//                    value = stringResource(id = R.string.register),
//                    onButtonClicked = {
//                        signupViewModel.onEvent(SignupUIEvent.RegisterButtonClicked)
//                    },
//                    isEnabled = signupViewModel.allValidationsPassed.value
//                )
//
//                Spacer(modifier = Modifier.height(20.dp))
//
//                DividerTextComponent()
//
//                ClickableLoginTextComponent(tryingToLogin = true, onTextSelected = {
//                    PostOfficeAppRouter.navigateTo(Screen.SignInScreen)
//                })
//            }
//
//        }
//
//        if(signupViewModel.signUpInProgress.value) {
//            CircularProgressIndicator()
//        }
//    }
//
//
//}