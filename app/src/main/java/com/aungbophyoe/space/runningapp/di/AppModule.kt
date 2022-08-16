package com.aungbophyoe.space.runningapp.di

import android.content.Context
import androidx.room.Room
import com.aungbophyoe.space.runningapp.data.RunningDatabase
import com.aungbophyoe.space.runningapp.utils.Constants.Database_Name
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideRunningDatabase(@ApplicationContext app : Context) = Room.databaseBuilder(
        app,
        RunningDatabase::class.java,
        Database_Name
    )   .fallbackToDestructiveMigration()
        .build()

    @Provides
    fun provideRunDao(db : RunningDatabase) = db.runDao()
}