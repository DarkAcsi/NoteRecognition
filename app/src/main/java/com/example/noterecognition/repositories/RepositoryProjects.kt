package com.example.noterecognition.repositories

import com.example.noterecognition.database.classes.CProject

typealias ProjectsListener = (projects: List<CProject>) -> Unit

interface ProjectsRepository {

//    // with database
//    suspend fun updateProject(project: Project): Project
//
//    suspend fun getById(id: Long): Project
//
//    suspend fun getNames(name: String, id: Long): Boolean
//
//    fun deleteProject(id: Long)
//
//    fun deleteProjects()
//
//    // without database
//    fun selectAllProjects(selected: Boolean?)
//
//    fun selectProjects(project: Project, selected: Boolean)
//
//    fun selectMoreProjects(project: Project): Boolean?

    // other
    fun addListener(listener: ProjectsListener)

    fun removeListener(listener: ProjectsListener)
}
