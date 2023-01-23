package com.example.composeapplication.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.composeapplication.model.dao.MatchDao
import com.example.composeapplication.model.dao.RecordDao
import com.example.composeapplication.model.entity.Match
import com.example.composeapplication.model.entity.Record

@Database(entities = [Match::class, Record::class], version = 1)
abstract class DatabaseService: RoomDatabase() {

    abstract fun MatchDao(): MatchDao
    abstract fun RecordDao(): RecordDao

}