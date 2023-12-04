package com.example.noterecognition.database.classes

data class CRecognition(
    val id: Long = 0, val projectId: Int, val dataCreation: String,
    val download: Boolean,
    val save: Boolean,
    val label: String?,
)