package com.example.noterecognition.screens.nataly.list

import com.example.noterecognition.base.BaseViewModel
import com.example.noterecognition.base.LiveResult
import com.example.noterecognition.base.MutableLiveResult
import com.example.noterecognition.base.PendingResult
import com.example.noterecognition.base.SuccessResult
import com.example.noterecognition.database.classes.CProject
import com.example.noterecognition.repositories.ProjectsListener
import com.example.noterecognition.repositories.ProjectsRepository

class ViewModelList(
    private val projectsRepository: ProjectsRepository,
) : BaseViewModel() {

    private val _projects = MutableLiveResult<List<CProject>>(PendingResult())
    val projects: LiveResult<List<CProject>> = _projects

    private val listener: ProjectsListener = {
        _projects.postValue(SuccessResult(it))
    }

    init {
        loadProjects()
    }

    override fun onCleared() {
        super.onCleared()
        projectsRepository.removeListener(listener)
    }

    fun tryAgain() {
        loadProjects()
    }

//    fun deleteProjects() {
//        projectsRepository.deleteProjects()
//    }
//
//    fun selectAllProjects(selected: Boolean?) {
//        projectsRepository.selectAllProjects(selected)
//    }
//
//    fun selectProjects(project: Project, selected: Boolean) {
//        projectsRepository.selectProjects(project, selected)
//    }
//
//    fun selectMoreProject(project: Project): Boolean? {
//        return projectsRepository.selectMoreProjects(project)
//    }

    private fun loadProjects() {
        projectsRepository.addListener(listener)
    }

}