package com.example.composeapplication.data.response


import com.google.gson.annotations.SerializedName

data class MatchItem(
    @SerializedName("AwayTeam")
    val awayTeam: String,
    @SerializedName("AwayTeamScore")
    val awayTeamScore: Int,
    @SerializedName("DateUtc")
    val dateUtc: String,
    @SerializedName("Group")
    val group: Any,
    @SerializedName("HomeTeam")
    val homeTeam: String,
    @SerializedName("HomeTeamScore")
    val homeTeamScore: Int,
    @SerializedName("Location")
    val location: String,
    @SerializedName("MatchNumber")
    val matchNumber: Int,
    @SerializedName("RoundNumber")
    val roundNumber: Int
)