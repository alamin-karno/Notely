package com.alaminkarno.notely.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alaminkarno.notely.model.Note
import com.alaminkarno.notely.repository.NoteRepository
import kotlinx.coroutines.launch

class NoteViewModel : ViewModel() {

    private val repository = NoteRepository()
    private val notes = MutableLiveData<List<Note>>()

    fun insert(context: Context, note: Note) {
        viewModelScope.launch {
            repository.insert(context, note)
        }
    }

    fun delete(context: Context, note: Note) {
        viewModelScope.launch {
            repository.delete(context, note)
        }
    }

    fun getAllNotes(context: Context) {
        viewModelScope.launch {
            notes.value = repository.getAllNotes(context)
        }
    }
}