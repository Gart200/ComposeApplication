package com.example.composeapplication.data.response


import com.google.gson.annotations.SerializedName

data class Group(
    @SerializedName("group_id")
    val groupId: Int,
    @SerializedName("group_name")
    val groupName: String
)