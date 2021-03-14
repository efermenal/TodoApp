package com.example.todo.ui.fragments

import androidx.lifecycle.*
import com.example.todo.db.NoteDao
import com.example.todo.global.DispatcherProvider
import com.example.todo.models.Note
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

class MainViewModel @Inject constructor (
        private val noteDao: NoteDao,
        private val dispatcher : DispatcherProvider,
) : ViewModel() {

    private val  _notesList =  MutableLiveData<List<Note>>()

    init {
        orderNotesByTitleASC()
    }

    private fun orderNotesByTitleASC() = viewModelScope.launch(dispatcher.io()) {
        noteDao.getAllNoteAsc().map {
            _notesList.postValue(it)
        }.collect()
    }

    val  notesList : LiveData<List<Note>>
            get() = _notesList

    fun insertNote(note : Note) = viewModelScope.launch(dispatcher.io()) {
        noteDao.insertNote(note)
    }

    fun updateNote(note : Note) = viewModelScope.launch(dispatcher.io()) {
        noteDao.updateNote(note)
    }

    fun deleteNote(note : Note) = viewModelScope.launch(dispatcher.io()) {
        noteDao.deleteNote(note)
    }

    fun deleteAllNotes() = viewModelScope.launch(dispatcher.io()) {
        noteDao.deleteAllNotes()
    }

    fun searchNoteByTitle(title : String) = viewModelScope.launch(dispatcher.io()) {
        noteDao.searchNoteByTitle(title).map {
            _notesList.postValue(it)
        }.collect()
    }

    fun sortNoteByNotePriority(order : String) = viewModelScope.launch(dispatcher.io()) {
        if (order == "H"){
            noteDao.sortNoteByPriorityAsc().map {
                _notesList.postValue(it)
            }.collect()
        }else{
            noteDao.sortNoteByPriorityDesc().map {
                _notesList.postValue(it)
            }.collect()
        }

    }

}