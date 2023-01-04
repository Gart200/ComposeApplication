package com.example.composeapplication.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeapplication.data.api.ApiService
import com.example.composeapplication.data.response.MatchItem
import kotlinx.coroutines.launch

class MatchViewModel: ViewModel() {

    var matchListResponse:List<MatchItem> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")

    fun getMatchDataList(){
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            try {
                val matchList = apiService.getMatches()
                matchListResponse = matchList
            }
            catch (e: java.lang.Exception){
                errorMessage = e.message.toString()
            }
        }
    }
}