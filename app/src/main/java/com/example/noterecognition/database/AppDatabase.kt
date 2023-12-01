package com.example.noterecognition.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.noterecognition.database.dao.DaoImages
import com.example.noterecognition.database.dao.DaoImagesSettings
import com.example.noterecognition.database.dao.DaoProjects
import com.example.noterecognition.database.dao.DaoProjectsSettings
import com.example.noterecognition.database.dao.DaoRecognitions
import com.example.noterecognition.database.dao.DaoSimpleMode
import com.example.noterecognition.database.entities.EntityImages
import com.example.noterecognition.database.entities.EntityImagesSettings
import com.example.noterecognition.database.entities.EntityProjects
import com.example.noterecognition.database.entities.EntityProjectsSettings
import com.example.noterecognition.database.entities.EntityRecognitions
import com.example.noterecognition.database.entities.EntitySimpleMode

@Database(
    version = 1,
    entities = [
        EntityProjects::class,
        EntityProjectsSettings::class,
        EntitySimpleMode::class,
        EntityImages::class,
        EntityImagesSettings::class,
        EntityRecognitions::class,
    ]
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getDaoProjects(): DaoProjects
    abstract fun getDaoProjectsSettings(): DaoProjectsSettings
    abstract fun getDaoSimpleMode(): DaoSimpleMode
    abstract fun getDaoImages(): DaoImages
    abstract fun getDaoImagesSettings(): DaoImagesSettings
    abstract fun getDaoRecognitions(): DaoRecognitions

}