package com.example.composeapplication.di

import com.example.composeapplication.repository.MatchRepository
import com.example.composeapplication.repository.RecordRepository
import com.example.composeapplication.repository.implementaiton.MatchRepositoryImpl
import com.example.composeapplication.repository.implementaiton.RecordRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun providerMatchRepository(matchRepositoryImpl: MatchRepositoryImpl): MatchRepository

    @Singleton
    @Binds
    abstract fun providerRecordRepository(recordRepositoryImpl: RecordRepositoryImpl): RecordRepository
}