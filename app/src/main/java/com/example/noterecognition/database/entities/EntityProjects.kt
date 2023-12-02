package com.example.noterecognition.database.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "projects",
    indices = [Index(value = ["name"], unique = true)],
//    foreignKeys = [
//        ForeignKey(
//            entity = EntityImages::class,
//            parentColumns = ["project_id"],
//            childColumns = ["id"]
//        ),
//        ForeignKey(
//            entity = EntityRecognitions::class,
//            parentColumns = ["project_id"],
//            childColumns = ["id"]
//        ),
//    ]
)
data class EntityProjects(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val position: Int,
    val save: Boolean,
)