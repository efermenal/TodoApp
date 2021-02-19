package com.example.todo.di

import com.example.todo.db.NoteDatabase
import dagger.Module
import dagger.Provides

@Module
class DaoModule {

    @Provides
    fun provideNoteDao(noteDatabase: NoteDatabase) = noteDatabase.getNoteDao()

}