package com.alaminkarno.notely.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.alaminkarno.notely.model.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDatabase: RoomDatabase() {

    companion object {
        fun get(context: Context): NoteDatabase {
            return Room.databaseBuilder(context, NoteDatabase::class.java, "note").build()
        }
    }

}