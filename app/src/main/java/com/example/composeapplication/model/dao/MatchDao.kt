package com.example.composeapplication.model.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.RawQuery
import com.example.composeapplication.model.entity.Match

@Dao
interface MatchDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    fun insertMatchList(match: List<Match>)

    @Query("SELECT * FROM `match` ORDER BY matchNumber")
    fun getMatchList(): LiveData<List<Match>>

    @Query("SELECT * FROM `match` WHERE homeTeam = :teamName OR awayTeam = :teamName COLLATE NOCASE ORDER BY matchNumber")
    fun getMatchByTeamName(teamName: String): LiveData<List<Match>>

    @Delete
    fun delete (match: Match)
}