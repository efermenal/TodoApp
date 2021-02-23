package com.example.todo.ui.fragments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.db.NoteDao
import com.example.todo.global.DispatcherProvider
import com.example.todo.models.Note
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor (
        private val noteDao: NoteDao,
        private val dispatcher : DispatcherProvider,
) : ViewModel() {

    fun insertNote(note : Note) = viewModelScope.launch(dispatcher.io()) {
        noteDao.insertNote(note)
    }

    fun updateNote(note : Note) = viewModelScope.launch(dispatcher.io()) {
        noteDao.updateNote(note)
    }

    fun deleteNote(note : Note) = viewModelScope.launch(dispatcher.io() + NonCancellable) {
        noteDao.deleteNote(note)
    }

    fun deleteAllNote() = viewModelScope.launch(dispatcher.io() + NonCancellable) {
        noteDao.deleteAllNotes()
    }






}