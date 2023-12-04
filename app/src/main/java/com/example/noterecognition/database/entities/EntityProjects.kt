package com.example.noterecognition.database.entities

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.noterecognition.database.classes.CProject

@Entity(
    tableName = "projects",
    indices = [Index(value = ["name"], unique = true)],
)
data class EntityProjects(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val position: Int,
    val save: Boolean,
){
    fun toCProject(): CProject = CProject(
        id = id,
        name = name,
        position = position,
        save = save,
        checked = false,
    )

    companion object {
        fun toEntityProject(project: CProject): EntityProjects = EntityProjects(
            id = project.id,
            name = project.name,
            position = project.position,
            save = project.save
        )
    }
}