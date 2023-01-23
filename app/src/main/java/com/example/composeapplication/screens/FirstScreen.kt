package com.example.composeapplication.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composeapplication.model.entity.Match
import com.example.composeapplication.ui.theme.Dark
import com.example.composeapplication.ui.theme.DarkBlue
import com.example.composeapplication.viewModel.MatchViewModel

@Composable
fun FirstScreen(viewModel: MatchViewModel = hiltViewModel()) {

    val matchList by viewModel.allMatches.observeAsState(arrayListOf())

    viewModel.loadMatchList()

    Box(modifier = Modifier.
    fillMaxSize().
    background(Dark)) {

        LazyColumn(
            contentPadding = PaddingValues(top = 12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(items = matchList) {
                MatchCard(match = it)
            }
        }
    }
}

@Composable
fun MatchCard(match: Match) {
    Card(
        modifier = Modifier
            .fillMaxSize(),
        backgroundColor = DarkBlue,
        shape = RoundedCornerShape(16.dp),
        elevation = 5.dp,

        ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(7.dp)
        ) {
            Text(text = "MatchNumber = ${match.matchNumber}", fontSize = 20.sp, color = White)
            Text(text = "RoundNumber = ${match.roundNumber}", fontSize = 20.sp, color = White)
            Text(text = "AwayTeam = ${match.awayTeam}", fontSize = 20.sp, color = White)
            Text(text = "AwayTeamScore = ${match.awayTeamScore}", fontSize = 20.sp, color = White)
            Text(text = "HomeTeam = ${match.homeTeam}", fontSize = 20.sp, color = White)
            Text(text = "HomeTeamScore = ${match.homeTeamScore}", fontSize = 20.sp, color = White)
            Text(text = "DateUTC = ${match.dateUtc}", fontSize = 20.sp, color = White)
            Text(text = "Location = ${match.location}", fontSize = 20.sp, color = White)
        }
    }
}
