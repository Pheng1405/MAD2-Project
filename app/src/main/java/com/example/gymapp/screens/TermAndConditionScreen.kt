package com.example.gymapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gymapp.R
import com.example.gymapp.components.HeadingTextComponent
import com.example.gymapp.components.NormalTextComponent

@Composable
fun TermsAndConditionsScreen(navController: NavController) {
    Surface(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)
        .padding(16.dp)) {



        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ){
            HeadingTextComponent(value = stringResource(id = R.string.terms_and_conditions_header))
            NormalTextComponent(value = stringResource(id = R.string.terms_and_conditions_text))
        }
    }

//    SystemBackButtonHandler {
////        PostOfficeAppRouter.navigateTo(Screen.SignUpScreen)
//    }
}

//@Preview
//@Composable
//fun TermsAndConditionsScreenPreview(){
//    TermsAndConditionsScreen()
//}