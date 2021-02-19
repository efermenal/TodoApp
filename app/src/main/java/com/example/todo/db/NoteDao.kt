package com.example.todo.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.todo.models.Note


@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note : Note)

    @Query("SELECT * FROM notes_table order by id ASC")
    fun getAllNoteAsc() : LiveData<List<Note>>

    @Query("SELECT * FROM notes_table order by id DESC")
    fun getAllNoteDesc() : LiveData<List<Note>>

}