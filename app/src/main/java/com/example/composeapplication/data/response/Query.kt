package com.example.composeapplication.data.response


import com.google.gson.annotations.SerializedName

data class Query(
    @SerializedName("apikey")
    val apikey: String,
    @SerializedName("season_id")
    val seasonId: String
)