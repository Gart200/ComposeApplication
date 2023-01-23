package com.example.composeapplication.viewModel

import android.text.TextUtils
import android.util.Log
import androidx.lifecycle.*
import com.example.composeapplication.model.entity.Match
import com.example.composeapplication.network.ConnectivityObserver
import com.example.composeapplication.repository.MatchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@HiltViewModel
class MatchViewModel @Inject constructor(
    private val matchRepositoryImpl: MatchRepository,
    private val connectivityObserver: ConnectivityObserver
) : ViewModel() {

    private val searchStringLiveData = MutableLiveData("")
    val allMatches: LiveData<List<Match>> = Transformations.switchMap(searchStringLiveData)
    {
        string->
        if (string == "") {
            matchRepositoryImpl.getMatchList()
        } else {
            matchRepositoryImpl.getMatchByTeamName(string)
        }
    }

    fun searchNameChanged(name: String) {
        searchStringLiveData.value = name
    }

    fun loadMatchList() {
        viewModelScope.launch {
            connectivityObserver.observe().collect {
                if (it == ConnectivityObserver.Status.AVAILABLE) {
                    viewModelScope.launch(Dispatchers.IO) {
                        matchRepositoryImpl.loadMatchList()
                    }
                }
            }
        }

    }
}
