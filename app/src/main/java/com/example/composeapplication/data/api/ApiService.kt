package com.example.composeapplication.data.api

import android.util.Log
import com.example.composeapplication.data.response.Matches
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import kotlin.math.log

val API_KEY = "54c4f560-7e13-11ed-a8d1-13d4e30ae90a"


interface ApiService {


    @GET("api/v1/soccer/matches")
    suspend fun getMatches(
        @Query("season_id") seasonId: Int = 424,
        @Query("apikey") apikey: String = API_KEY
    ): Matches


    companion object {

        val interceptor = run {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.apply {
                httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            }
        }

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(interceptor) // same for .addInterceptor(...)
            .build()


        var apiService: ApiService? = null

        fun getInstance(): ApiService {
            if (apiService == null) {
                apiService = Retrofit.Builder()
                    .baseUrl("https://app.sportdataapi.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build().create(ApiService::class.java)
            }
            return apiService!!
        }
//        operator fun invoke(): ApiService {
//
//
//            val requestInterceptor = Interceptor { chain ->
//                val url = chain.request()
//                    .url
//                    .newBuilder()
//                    .addQueryParameter("apikey", API_KEY)
//                    .build()
//
//                val request = chain.request()
//                    .newBuilder()
//                    .url(url)
//                    .build()
//
//                return@Interceptor chain.proceed(request)
//            }
//
//            val okHttpClient = OkHttpClient.Builder()
//                .addInterceptor(requestInterceptor)
//                .build()
//
//            return Retrofit.Builder()
//                .client(okHttpClient)
//                .baseUrl("https://app.sportdataapi.com/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//                .create(ApiService::class.java)
//        }


    }

}