package com.example.noterecognition

import android.content.Context
import androidx.room.Room
import com.example.noterecognition.database.AppDatabase

object Repositories {

    private lateinit var applicationContext: Context

    val database: AppDatabase by lazy {
        Room.databaseBuilder(applicationContext, AppDatabase::class.java, "database.db")
            .fallbackToDestructiveMigration()
            .build()
    }

//    val projectsRepository: ProjectsRepository by lazy {
//        RoomProjectsRepository(database.getProjectDao(), database.getImageDao())
//    }

    fun init(context: Context) {
        applicationContext = context
    }

}