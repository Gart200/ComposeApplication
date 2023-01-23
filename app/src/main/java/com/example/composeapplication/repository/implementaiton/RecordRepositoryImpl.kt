package com.example.composeapplication.repository.implementaiton

import androidx.lifecycle.LiveData
import com.example.composeapplication.data.api.ApiService
import com.example.composeapplication.model.dao.MatchDao
import com.example.composeapplication.model.dao.RecordDao
import com.example.composeapplication.model.entity.Match
import com.example.composeapplication.model.entity.Record
import com.example.composeapplication.repository.MatchRepository
import com.example.composeapplication.repository.RecordRepository
import javax.inject.Inject

class RecordRepositoryImpl @Inject constructor(
    private val recordDao: RecordDao
) : RecordRepository {

    override fun getRecordList(): LiveData<List<Record>> = recordDao.getRecordList()

}
