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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composeapplication.model.entity.Record
import com.example.composeapplication.ui.theme.Dark
import com.example.composeapplication.ui.theme.DarkBlue
import com.example.composeapplication.viewModel.RecordViewModel

@Composable
fun SecondScreen(viewModel: RecordViewModel = hiltViewModel()) {

    val recordList by viewModel.recordList.observeAsState(arrayListOf())

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Dark)
    ) {
        LazyColumn(
            contentPadding = PaddingValues(top = 12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(items = recordList) {
                TextCard(record = it)
            }
        }
    }
}

@Composable
fun TextCard(record: Record) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        backgroundColor = DarkBlue,
        shape = RoundedCornerShape(16.dp),
        elevation = 5.dp,

        ) {
        Row(
            horizontalArrangement = Arrangement.Start,
        ) {
            Text(
                modifier = Modifier.padding(7.dp),
                text = "${record.key}: ${record.value}",
                color = Color.White,
                fontSize = 20.sp,
            )
        }
    }
}