package com.example.composeapplication.data.api

import com.example.composeapplication.model.entity.Match
import retrofit2.http.GET

interface ApiService {

    @GET("feed/json/epl-2021")
    suspend fun getMatches(): List<Match>

}