package com.example.noterecognition.database.classes

data class CProjectSettings(
    val id: Long = 0,
    val projectId: Int,
    val description: String,
    val countPages: Int,
)