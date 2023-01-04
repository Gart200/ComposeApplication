package com.example.composeapplication.data.api

import com.example.composeapplication.data.response.MatchItem
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {

    @GET("feed/json/epl-2021")
    suspend fun getMatches(): List<MatchItem>

    companion object {

        private val interceptor = run {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.apply {
                httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            }
        }

        private val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(interceptor).build()


        var apiService: ApiService? = null

        fun getInstance(): ApiService {
            if (apiService == null) {
                apiService = Retrofit.Builder()
                    .baseUrl("https://fixturedownload.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build().create(ApiService::class.java)
            }
            return apiService!!
        }
    }

}