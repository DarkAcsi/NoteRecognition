package com.example.noterecognition.database.classes

data class CRecognitions(
    val id: Long = 0, val projectId: Int, val dataCreation: String,
    val download: Boolean,
    val save: Boolean,
    val label: String?,
)