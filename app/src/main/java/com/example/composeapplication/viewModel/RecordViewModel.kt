package com.example.composeapplication.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.composeapplication.model.entity.Record
import com.example.composeapplication.repository.RecordRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RecordViewModel @Inject constructor(
    private val recordRepositoryImpl: RecordRepository
) : ViewModel() {

    val recordList: LiveData<List<Record>> by lazy {
        recordRepositoryImpl.getRecordList()
    }

}
