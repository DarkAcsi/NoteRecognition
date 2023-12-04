package com.example.noterecognition.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.noterecognition.database.classes.CProject
import com.example.noterecognition.database.entities.EntityProjects
import kotlinx.coroutines.flow.Flow

@Dao
interface DaoProjects{
    @Query("SELECT id, name, position, save, 0 AS checked FROM projects")
    fun getAllProjects(): Flow<List<CProject>>

    @Query("SElECT name FROM projects")
    fun getNames(): List<String>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrUpdateProject(project: EntityProjects): Long

    @Query("DELETE FROM projects WHERE id IN (:indexes)")
    fun deleteProjects(indexes: List<Long>)

}