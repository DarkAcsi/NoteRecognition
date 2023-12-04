package com.example.noterecognition.database.classes

data class CProject(
    val id: Long = 0,
    val name: String,
    val position: Int,
    val save: Boolean,
    val checked: Boolean = false,
)