package com.example.noterecognition.database.classes

data class CImage(
    val id: Long,
    val projectId: Int,
    val position: Int,
    val resImage: String,
)