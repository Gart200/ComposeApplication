package com.example.composeapplication.repository

import androidx.lifecycle.LiveData
import com.example.composeapplication.model.entity.Match
import com.example.composeapplication.model.entity.Record

interface RecordRepository {
    fun getRecordList(): LiveData <List<Record>>

}

