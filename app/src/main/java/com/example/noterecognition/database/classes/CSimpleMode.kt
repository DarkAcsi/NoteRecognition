package com.example.noterecognition.database.classes

data class CSimpleMode(
    val id: Long = 0,
    val projectId: Int,
    val timePage: Int,
    val timeAll: Int,
    val countDown: Int,
)