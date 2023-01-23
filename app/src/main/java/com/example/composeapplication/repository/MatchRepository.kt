package com.example.composeapplication.repository

import androidx.lifecycle.LiveData
import com.example.composeapplication.model.entity.Match

interface MatchRepository {
    fun getMatchList(): LiveData <List<Match>>
    suspend fun loadMatchList()
    fun getMatchByTeamName(teamName: String): LiveData <List<Match>>
}

