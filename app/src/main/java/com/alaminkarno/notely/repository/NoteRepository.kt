package com.alaminkarno.notely.repository

import android.content.Context
import com.alaminkarno.notely.model.Note
import com.alaminkarno.notely.room.NoteDatabase

class NoteRepository {

    suspend fun insert(context: Context, note: Note) {
        NoteDatabase.get(context).getNoteDAO().insert(note)
    }

    suspend fun delete(context: Context, note: Note) {
        NoteDatabase.get(context).getNoteDAO().delete(note)
    }

    suspend fun getAllNotes(context: Context): List<Note> {
        return NoteDatabase.get(context).getNoteDAO().getAllNotes()
    }
}