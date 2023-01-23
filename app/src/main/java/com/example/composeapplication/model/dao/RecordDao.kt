package com.example.composeapplication.model.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.composeapplication.model.entity.Record

@Dao
interface RecordDao {
    @Query("SELECT * FROM `record`")
    fun getRecordList(): LiveData<List<Record>>
}