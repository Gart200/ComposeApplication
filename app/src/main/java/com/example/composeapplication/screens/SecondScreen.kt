package com.example.composeapplication.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.composeapplication.TextCard
import com.example.composeapplication.model.Record

@Composable
fun SecondScreen(records: List<Record>) {

    LazyColumn(
        contentPadding = PaddingValues(all = 12.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(items = records) {
            TextCard(record = it)
        }
    }

}