package com.aungbophyoe.space.runningapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.aungbophyoe.space.runningapp.utils.Converters

@Database(
    entities = [RunEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class RunningDatabase : RoomDatabase(){
    abstract fun runDao() : RunDAO
}