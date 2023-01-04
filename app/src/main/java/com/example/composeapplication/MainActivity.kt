package com.example.composeapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.res.painterResource
import com.example.composeapplication.elements.TopBar
import com.example.composeapplication.screens.SecondScreen
import com.example.composeapplication.screens.FirstScreen
import com.example.composeapplication.model.Record
import com.example.composeapplication.ui.theme.Dark
import com.example.composeapplication.ui.theme.LightPurple
import com.example.composeapplication.ui.theme.LightRed
import com.example.composeapplication.viewModel.MatchViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private fun getRecordsList(): List<Record> {
        val jsonFileString = getJsonDataFromAsset(applicationContext, "records.json")

        val gson = Gson()
        val listRecordsType = object : TypeToken<List<Record>>() {}.type

        return gson.fromJson(jsonFileString, listRecordsType)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {

            val matchViewModel by viewModels<MatchViewModel>()


            var bottomState by remember {
                mutableStateOf("First")
            }

            Scaffold(
                topBar = { TopBar() },
                content = { padding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(padding)
                            .background(Dark)
                    ) {
                        when (bottomState) {
                            "First" -> FirstScreen(matchViewModel.matchListResponse)
                            "Second" -> SecondScreen(getRecordsList())
                        }
                    }
                },
                bottomBar = {
                    BottomNavigation(backgroundColor = LightPurple) {
                        BottomNavigationItem(
                            selected = bottomState == "First",
                            onClick = { bottomState = "First" },
                            label = { Text(text = "First") },
                            icon = {
                                Icon(
                                    painter = painterResource(R.drawable.ic_baseline_looks_one_24),
                                    contentDescription = "Second"
                                )
                            },
                            selectedContentColor = LightRed,
                            unselectedContentColor = Black
                        )
                        BottomNavigationItem(
                            selected = bottomState == "Second",
                            onClick = { bottomState = "Second" },
                            label = { Text(text = "Second") },
                            icon = {
                                Icon(
                                    painter = painterResource(R.drawable.ic_baseline_looks_two_24),
                                    contentDescription = "Second"
                                )
                            },
                            selectedContentColor = LightRed,
                            unselectedContentColor = Black
                        )

                    }
                }
            )
            matchViewModel.getMatchDataList()

        }
    }


}






