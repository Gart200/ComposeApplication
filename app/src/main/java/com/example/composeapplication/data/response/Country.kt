package com.example.composeapplication.data.response


import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("continent")
    val continent: String,
    @SerializedName("country_code")
    val countryCode: Any,
    @SerializedName("country_id")
    val countryId: Int,
    @SerializedName("name")
    val name: String
)