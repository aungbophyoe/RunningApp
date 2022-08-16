package com.aungbophyoe.space.runningapp.mapper

import androidx.lifecycle.LiveData
import com.aungbophyoe.space.runningapp.data.RunEntity
import com.aungbophyoe.space.runningapp.model.Run
import javax.inject.Inject

class CacheMapper @Inject constructor() : EntityMapper<RunEntity,Run> {
    override fun mapFromEntity(entity: RunEntity): Run {
        return Run(entity.img,entity.timestamp,entity.avgSpeedInKMH,entity.distanceInMeters,entity.timeInMillis,entity.caloriesBurned)
    }

    override fun mapToEntity(domainModel: Run): RunEntity {
        return RunEntity(domainModel.img,domainModel.timestamp,domainModel.avgSpeedInKMH,domainModel.distanceInMeters,domainModel.timeInMillis,domainModel.caloriesBurned)
    }

    fun mapFromEntityList(entities : List<RunEntity>) : List<Run>{
        return entities.map { mapFromEntity(it) }
    }
}