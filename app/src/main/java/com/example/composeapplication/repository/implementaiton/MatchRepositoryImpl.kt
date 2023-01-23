package com.example.composeapplication.repository.implementaiton

import androidx.lifecycle.LiveData
import com.example.composeapplication.data.api.ApiService
import com.example.composeapplication.model.dao.MatchDao
import com.example.composeapplication.model.entity.Match
import com.example.composeapplication.repository.MatchRepository
import javax.inject.Inject

class MatchRepositoryImpl @Inject constructor(
    private val matchDao: MatchDao,
    private val apiService: ApiService
) : MatchRepository {

    override fun getMatchList(): LiveData<List<Match>> = matchDao.getMatchList()

    override suspend fun loadMatchList() = matchDao.insertMatchList(apiService.getMatches())

    override fun getMatchByTeamName(teamName: String): LiveData<List<Match>> = matchDao.getMatchByTeamName(teamName)

}
