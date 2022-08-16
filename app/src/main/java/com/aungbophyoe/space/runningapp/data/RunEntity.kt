package com.aungbophyoe.space.runningapp.data

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "running_table")
data class RunEntity(
    @ColumnInfo(name = "image") var img: Bitmap? = null,
    @ColumnInfo(name = "time_stamp") var timestamp: Long = 0L,
    @ColumnInfo(name = "avgSpeed_in_KMH") var avgSpeedInKMH: Float = 0f,
    @ColumnInfo(name = "distance_in_meters") var distanceInMeters: Int = 0,
    @ColumnInfo(name = "time_in_millis") var timeInMillis: Long = 0L,
    @ColumnInfo(name = "calories_burned") var caloriesBurned: Int = 0
) {
    @PrimaryKey(autoGenerate = true)
    var id : Int? = null
}