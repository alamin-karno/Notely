package com.alaminkarno.notely.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.alaminkarno.notely.model.Note

@Dao
interface NoteDAO {

    @Insert
    suspend fun insert(note: Note)

    @Delete
    suspend fun delete(note: Note)

    @Query("SELECT * FROM Note")
    suspend fun getAllNotes(): List<Note>

}