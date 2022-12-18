package com.example.composeapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.composeapplication.data.response.MatchData
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun MatchCard(matchData: MatchData) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        elevation = 5.dp,


        ) {

        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
                .padding(8.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxHeight()
            ) {
                Image(
                    painter = rememberAsyncImagePainter(model = matchData.homeTeam.logo),
                    contentDescription = "HomeTeamLogo",
                    modifier = Modifier
                        .size(64.dp)
                        .height(50.dp)
                        .width(100.dp)

                )
                Text(text = matchData.homeTeam.shortCode)
            }
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxHeight()
            ) {
                Text(
                    text = "${matchData.stats.homeScore} - ${matchData.stats.awayScore}",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                if (matchData.group.groupName != "Knockout stage")
                    Text(
                        text = "Group: ${matchData.group.groupName}",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                else Text(
                    text = "Playoff",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

            }
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxHeight()
            ) {
                Image(
                    painter = rememberAsyncImagePainter(model = matchData.awayTeam.logo),
                    contentDescription = "HomeTeamLogo",
                    modifier = Modifier
                        .size(64.dp)
                        .height(50.dp)
                        .width(100.dp)
                )
                Text(text = matchData.awayTeam.shortCode)
            }

        }
    }
}