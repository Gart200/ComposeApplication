package com.example.composeapplication.screens.navigation

import com.example.composeapplication.R

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val iconResource: Int
) {
    object FirstScreen : BottomBarScreen(
        route = "firstScreen",
        title = "First",
        iconResource = R.drawable.ic_baseline_looks_one_24
    )
    object SecondScreen : BottomBarScreen(
        route = "SecondScreen",
        title = "Second",
        iconResource = R.drawable.ic_baseline_looks_two_24
    )
}
