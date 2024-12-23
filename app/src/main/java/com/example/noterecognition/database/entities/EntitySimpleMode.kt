package com.example.noterecognition.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "simple_mode",
        foreignKeys = [
            ForeignKey(
                entity = EntityProjects::class,
                parentColumns = ["id"],
                childColumns = ["project_id"]
            ),
    ]
)
data class EntitySimpleMode(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "project_id") val projectId: Int,
    @ColumnInfo(name = "time_page") val timePage: Int,
    @ColumnInfo(name = "time_all") val timeAll: Int,
    @ColumnInfo(name = "count_down") val countDown: Int,
)