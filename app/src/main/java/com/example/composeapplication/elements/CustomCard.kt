package com.example.composeapplication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeapplication.model.Record

@Composable
fun CustomCard(record: Record) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        elevation = 5.dp,

        ) {
        Row(
            horizontalArrangement = Arrangement.Start,
        ) {
            Text(
                modifier = Modifier.padding(10.dp),
                text = "${record.key}: ${record.value}",
                fontSize = 25.sp,
            )
        }
    }
}