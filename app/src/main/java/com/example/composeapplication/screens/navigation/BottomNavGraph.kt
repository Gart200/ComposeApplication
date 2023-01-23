package com.example.composeapplication.screens.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeapplication.screens.FirstScreen
import com.example.composeapplication.screens.SecondScreen
import com.example.composeapplication.viewModel.MatchViewModel
import javax.inject.Inject

@Composable
fun BottomNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.FirstScreen.route
    ){
        composable (
            route = BottomBarScreen.FirstScreen.route){
            FirstScreen()
        }
        composable(route = BottomBarScreen.SecondScreen.route){
            SecondScreen()
        }
    }

}