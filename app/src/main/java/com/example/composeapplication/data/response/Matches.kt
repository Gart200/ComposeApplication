package com.example.composeapplication.data.response


import com.google.gson.annotations.SerializedName

data class Matches(
    @SerializedName("data")
    val matchData: List<MatchData>,
    @SerializedName("query")
    val query: Query
)