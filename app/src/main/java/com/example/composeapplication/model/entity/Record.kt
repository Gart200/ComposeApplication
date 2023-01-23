package com.example.composeapplication.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "record")
data class Record(
    @PrimaryKey
    val key: String,
    val value: String?)
