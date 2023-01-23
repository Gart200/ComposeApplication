package com.example.composeapplication.model.entity


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity (tableName = "match")
data class Match(
    @SerializedName("MatchNumber")
    @PrimaryKey
    val matchNumber: Int,
    @SerializedName("AwayTeam")
    val awayTeam: String,
    @SerializedName("AwayTeamScore")
    val awayTeamScore: Int,
    @SerializedName("DateUtc")
    val dateUtc: String,
    @SerializedName("Group")
    val group: String?,
    @SerializedName("HomeTeam")
    val homeTeam: String,
    @SerializedName("HomeTeamScore")
    val homeTeamScore: Int,
    @SerializedName("Location")
    val location: String,
    @SerializedName("RoundNumber")
    val roundNumber: Int
)