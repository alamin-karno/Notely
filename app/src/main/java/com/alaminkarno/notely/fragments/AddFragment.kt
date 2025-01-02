package com.alaminkarno.notely.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.alaminkarno.notely.R
import com.alaminkarno.notely.model.Note
import com.alaminkarno.notely.viewmodel.NoteViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton


class AddFragment : Fragment() {

    private lateinit var controller: NavController
    private lateinit var viewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this)[NoteViewModel::class.java]
        return inflater.inflate(R.layout.fragment_add, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        controller = Navigation.findNavController(view)

        val title = view.findViewById<EditText>(R.id.add_note_title)
        val description = view.findViewById<EditText>(R.id.add_note_description)
        val saveNoteButton = view.findViewById<FloatingActionButton>(R.id.save_note_nav_button)

        saveNoteButton.setOnClickListener {
            val noteTitle = title.text.trim().toString()
            val noteDescription = description.text.trim().toString()

            if(noteTitle.isNotEmpty() && noteDescription.isNotEmpty()) {
                saveNoteToDatabase(Note(noteTitle,noteDescription))
                controller.navigate(R.id.action_addFragment_to_mainFragment)
            } else if(noteTitle.isEmpty()) {
                title.error = "Title is required"
            } else if(noteDescription.isEmpty()) {
                description.error = "Description is required"
            }
        }
    }

    private fun saveNoteToDatabase(note: Note){
        context?.let { viewModel.insert(it,note) }
    }

}