package com.aungbophyoe.space.runningapp.repository

import com.aungbophyoe.space.runningapp.data.RunDAO
import com.aungbophyoe.space.runningapp.mapper.CacheMapper
import com.aungbophyoe.space.runningapp.model.Run
import com.aungbophyoe.space.runningapp.utils.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MainRepository @Inject constructor(private val runDAO: RunDAO,private val cacheMapper: CacheMapper) {
    suspend fun insertRun(run: Run) {
        val entity = cacheMapper.mapToEntity(run)
        runDAO.insertRun(entity)
    }
    suspend fun deleteRun(run: Run) {
        val entity = cacheMapper.mapToEntity(run)
        runDAO.deleteRun(entity)
    }
    suspend fun getAllRunsSortedByDate() : Flow<DataState<List<Run>>> = flow {
         emit(DataState.Loading)
         try {
             val entities = runDAO.getAllRunsSortedByDate()
             val runs = cacheMapper.mapFromEntityList(entities)
             emit(DataState.Success(runs))
         } catch (e:Exception){
             emit(DataState.Error(e))
         }
    }
    suspend fun getAllRunsSortedByTimeInMillis() : Flow<DataState<List<Run>>> = flow {
        emit(DataState.Loading)
        try {
            val entities = runDAO.getAllRunsSortedByTimeInMillis()
            val runs = cacheMapper.mapFromEntityList(entities)
            emit(DataState.Success(runs))
        } catch (e:Exception){
            emit(DataState.Error(e))
        }
    }
    suspend fun getAllRunsSortedByCaloriesBurned() : Flow<DataState<List<Run>>> = flow {
        emit(DataState.Loading)
        try {
            val entities = runDAO.getAllRunsSortedByCaloriesBurned()
            val runs = cacheMapper.mapFromEntityList(entities)
            emit(DataState.Success(runs))
        } catch (e:Exception){
            emit(DataState.Error(e))
        }
    }
    suspend fun getAllRunsSortedByAvgSpeed() : Flow<DataState<List<Run>>> = flow {
        emit(DataState.Loading)
        try {
            val entities = runDAO.getAllRunsSortedByAvgSpeed()
            val runs = cacheMapper.mapFromEntityList(entities)
            emit(DataState.Success(runs))
        } catch (e:Exception){
            emit(DataState.Error(e))
        }
    }
    suspend fun getAllRunsSortedByDistance() : Flow<DataState<List<Run>>> = flow {
        emit(DataState.Loading)
        try {
            val entities = runDAO.getAllRunsSortedByDistance()
            val runs = cacheMapper.mapFromEntityList(entities)
            emit(DataState.Success(runs))
        } catch (e:Exception){
            emit(DataState.Error(e))
        }
    }
    suspend fun getTotalTimeInMillis() = runDAO.getTotalTimeInMillis()

    suspend fun getTotalCaloriesBurned() = runDAO.getTotalCaloriesBurned()

    suspend fun getTotalDistance() = runDAO.getTotalDistance()

    suspend fun getTotalAvgSpeed() = runDAO.getTotalAvgSpeed()
}