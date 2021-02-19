package com.example.todo.db

import android.content.Context
import androidx.room.*
import com.example.todo.models.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
@TypeConverters(DatabaseConverters::class)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun getNoteDao() : NoteDao

    companion object{
        @Volatile
        private var INSTANCE : NoteDatabase? = null

        fun getDatabase(context: Context) : NoteDatabase{
            val instanceTmp = INSTANCE
            if (instanceTmp != null){
                return instanceTmp
            }

            synchronized(this){
                val instance  = Room
                    .databaseBuilder(
                        context.applicationContext,
                        NoteDatabase::class.java,
                        "note_database"
                    ).build()
                INSTANCE = instance
                return instance
            }
        }

    }

}