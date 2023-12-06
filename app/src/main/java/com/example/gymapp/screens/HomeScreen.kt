package com.example.gymapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.gymapp.R
import com.example.gymapp.components.AppToolbar
import com.example.gymapp.data.home.HomeViewModel


@Composable
fun HomeScreen(homeViewModel: HomeViewModel = viewModel()) {

//    val scaffoldState = rememberScaffoldState()
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    homeViewModel.getUserData()

    Scaffold(

//        topBar = {
//            AppToolbar(toolbarTitle = stringResource(id = R.string.home),
//                logoutButtonClicked = {
//                    homeViewModel.logout()
//                },
//                navigationIconClicked = {
//                    coroutineScope.launch {
//                        scaffoldState.drawerState.open()
//                    }
//                }
//            )
//        },
//        drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
//        drawerContent = {
//            NavigationDrawerHeader(homeViewModel.emailId.value)
//            NavigationDrawerBody(navigationDrawerItems = homeViewModel.navigationItemsList,
//                onNavigationItemClicked = {
//                    Log.d("ComingHere","inside_NavigationItemClicked")
//                    Log.d("ComingHere","${it.itemId} ${it.title}")
//                })
//        }

    ) { paddingValues ->

        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(paddingValues)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {


            }

        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}