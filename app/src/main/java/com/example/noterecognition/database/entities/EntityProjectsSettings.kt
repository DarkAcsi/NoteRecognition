package com.example.noterecognition.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "projects_settings",
    indices = [Index(value = ["project_id"])],
    foreignKeys = [
        ForeignKey(
            entity = EntityProjects::class,
            parentColumns = ["id"],
            childColumns = ["project_id"]
        ),
    ]
)
data class EntityProjectsSettings(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "project_id") val projectId: Int,
    val description: String,
    @ColumnInfo(name = "count_pages") val countPages: Int,
)