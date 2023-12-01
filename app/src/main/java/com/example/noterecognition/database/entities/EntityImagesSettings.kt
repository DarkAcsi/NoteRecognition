package com.example.noterecognition.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "images_settings",
//    indices = [Index(value = ["res_image"], unique = true)],
    indices = [Index(value = ["res_image"])]
)
data class EntityImagesSettings(
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "res_image") val resImage: String, // Uri
)