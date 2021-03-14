package com.example.todo.db


import androidx.room.*
import com.example.todo.models.Note
import kotlinx.coroutines.flow.Flow


@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note : Note)

    @Update
    suspend fun updateNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Query("DELETE FROM notes_table")
    suspend fun deleteAllNotes()

    @Query("SELECT * FROM notes_table order by id ASC")
    fun getAllNoteAsc() : Flow<List<Note>>

    @Query("SELECT * FROM notes_table WHERE title LIKE :title")
    fun searchNoteByTitle(title : String) : Flow<List<Note>>

    @Query("SELECT * FROM notes_table ORDER BY CASE WHEN priority ='HIGH' THEN 1 WHEN  priority ='MEDIUM' THEN 2 WHEN priority = 'LOW'  THEN 3 END ASC")
    fun sortNoteByPriorityAsc() : Flow<List<Note>>

    @Query("SELECT * FROM notes_table ORDER BY CASE WHEN priority ='HIGH' THEN 1 WHEN  priority ='MEDIUM' THEN 2 WHEN priority = 'LOW'  THEN 3 END DESC")
    fun sortNoteByPriorityDesc() : Flow<List<Note>>
}