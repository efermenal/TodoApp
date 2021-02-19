package com.example.todo.di

import android.content.Context
import com.example.todo.db.NoteDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [DaoModule::class])
class DatabaseModule {

    @Singleton
    @Provides
    fun provideNoteDatabase(context: Context) = NoteDatabase.getDatabase(context)

}