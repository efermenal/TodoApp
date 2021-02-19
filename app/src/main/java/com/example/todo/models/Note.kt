package com.example.todo.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")
data class Note(
        @PrimaryKey(autoGenerate = true)  var id : Int,
        var title : String,
        var description : String,
        var priority: Priority,
)
