package com.example.todo.db

import androidx.room.TypeConverter
import com.example.todo.models.Priority


class DatabaseConverters {

    @TypeConverter
    fun fromPriority(priority: Priority) : String{
        return priority.name
    }

    @TypeConverter
    fun toPriority(priority: String) : Priority{
        return Priority.valueOf(priority)
    }
}