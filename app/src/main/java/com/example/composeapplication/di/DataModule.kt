package com.example.composeapplication.di

import android.content.Context
import androidx.room.Room
import com.example.composeapplication.data.api.ApiService
import com.example.composeapplication.data.database.DatabaseService
import com.example.composeapplication.model.dao.MatchDao
import com.example.composeapplication.model.dao.RecordDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://fixturedownload.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): DatabaseService {
        return Room.databaseBuilder(context, DatabaseService::class.java, "premierdb")
            .createFromAsset("database/premierdb.db")
            .build()
    }

    @Singleton
    @Provides
    fun matchDao(databaseService: DatabaseService): MatchDao = databaseService.MatchDao()


    @Singleton
    @Provides
    fun recordDao(databaseService: DatabaseService): RecordDao = databaseService.RecordDao()



}