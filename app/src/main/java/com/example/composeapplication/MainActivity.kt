package com.example.composeapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composeapplication.model.Record
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity : ComponentActivity() {


    fun getRecordsList(): List<Record> {
        val jsonFileString = getJsonDataFromAsset(applicationContext, "records.json")

        val gson = Gson()
        val listRecordsType = object : TypeToken<List<Record>>() {}.type

        return gson.fromJson(jsonFileString, listRecordsType)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val records = getRecordsList()

        setContent {

            Scaffold(
                content = {

                    LazyColumn(
                        contentPadding = PaddingValues(all = 12.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(items = records) {
                            CustomCard(record = it)
                        }
                    }


                },
                topBar = { TopBar() }
            )


        }
    }

}



