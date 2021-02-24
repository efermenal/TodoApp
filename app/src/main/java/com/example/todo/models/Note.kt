package com.example.todo.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Entity(tableName = "notes_table")
@Parcelize
data class Note(
        @PrimaryKey(autoGenerate = true)  var id : Int,
        var title : String,
        var description : String,
        var priority: Priority,
): Parcelable
