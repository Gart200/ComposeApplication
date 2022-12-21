package com.example.composeapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.composeapplication.data.response.MatchItem

@Composable
fun MatchCard(match: MatchItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        elevation = 5.dp,

        ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(5.dp)
        ) {

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min)
                    .padding(horizontal = 5.dp)


            ) {
                Text(
                    text = "${match.dateUtc.dropLast(1)}",
                    fontSize = 14.sp,
                )
                Text(
                    text = "${match.location}",
                    fontSize = 14.sp,
                )
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min)
                    .padding(horizontal = 5.dp)
            ) {
                Text(
                    text = "MatchNumber: ${match.matchNumber}",
                    fontSize = 14.sp,
                )
                Text(
                    text = "RoundNumber: ${match.roundNumber}",
                    fontSize = 14.sp,
                )
            }
            Divider(thickness = 1.dp, color = Color.Black)

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min)
                    .padding(horizontal = 10.dp, vertical = 6.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxHeight()
                ) {
                    Text(
                        text = match.homeTeam,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxHeight()

                ) {


                    Text(
                        text = "${match.homeTeamScore} - ${match.awayTeamScore}",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )


                }
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxHeight()
                ) {
                    Text(
                        text = match.awayTeam,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

            }
        }
    }
}
