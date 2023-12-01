package com.example.noterecognition.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "recognitions",
    indices = [Index(value = ["project_id"])],
)
data class EntityRecognitions(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "project_id") val projectId: Int,
    @ColumnInfo(name = "data_creation") val dataCreation: String,
    val download: Boolean,
    val save: Boolean,
    val label: String?,
)