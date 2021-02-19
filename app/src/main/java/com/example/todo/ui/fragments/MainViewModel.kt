package com.example.todo.ui.fragments

import androidx.lifecycle.ViewModel
import com.example.todo.db.NoteDao
import javax.inject.Inject

class MainViewModel @Inject constructor (val noteDao: NoteDao) : ViewModel() {

}