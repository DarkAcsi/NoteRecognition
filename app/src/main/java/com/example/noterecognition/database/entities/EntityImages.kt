package com.example.noterecognition.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "images",
    indices = [Index(value = ["project_id"])],
    foreignKeys = [
        ForeignKey(
            entity = EntityImagesSettings::class,
            parentColumns = ["id"],
            childColumns = ["id"]
        ),
    ]
)
data class EntityImages(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "project_id") val projectId: Int,
    val position: Int,
    @ColumnInfo(name = "res_image") val resImage: String, // Uri
)