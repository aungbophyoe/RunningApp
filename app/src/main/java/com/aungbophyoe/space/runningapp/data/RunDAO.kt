package com.aungbophyoe.space.runningapp.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface RunDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRun(runEntity: RunEntity)

    @Delete
    suspend fun deleteRun(runEntity: RunEntity)

    @Query("SELECT * FROM running_table ORDER BY time_stamp DESC")
    fun getAllRunsSortedByDate() : List<RunEntity>

    @Query("SELECT * FROM running_table ORDER BY time_in_millis DESC")
    fun getAllRunsSortedByTimeInMillis() : List<RunEntity>

    @Query("SELECT * FROM running_table ORDER BY calories_burned DESC")
    fun getAllRunsSortedByCaloriesBurned() : List<RunEntity>

    @Query("SELECT * FROM running_table ORDER BY avgSpeed_in_KMH DESC")
    fun getAllRunsSortedByAvgSpeed() : List<RunEntity>

    @Query("SELECT * FROM running_table ORDER BY distance_in_meters DESC")
    fun getAllRunsSortedByDistance() : List<RunEntity>

    @Query("SELECT SUM(time_in_millis) FROM running_table")
    fun getTotalTimeInMillis() : LiveData<Long>

    @Query("SELECT SUM(calories_burned) FROM running_table")
    fun getTotalCaloriesBurned() : LiveData<Int>

    @Query("SELECT SUM(distance_in_meters) FROM running_table")
    fun getTotalDistance() : LiveData<Int>

    @Query("SELECT SUM(avgSpeed_in_KMH) FROM running_table")
    fun getTotalAvgSpeed() : LiveData<Float>
}