package com.alaminkarno.notely.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.alaminkarno.notely.R
import com.alaminkarno.notely.adapters.RecyclerAdapter
import com.alaminkarno.notely.viewmodel.NoteViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainFragment : Fragment() {

    private lateinit var controller : NavController
    private lateinit var viewModel: NoteViewModel
    private var adapter = RecyclerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this)[NoteViewModel::class.java]
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        controller = Navigation.findNavController(view)

        val button = view.findViewById<FloatingActionButton>(R.id.add_note_fav_button)
        val recyclerView = view.findViewById<RecyclerView>(R.id.notes_recyclerView)

        button.setOnClickListener {
            controller.navigate(R.id.action_mainFragment_to_addFragment)
        }

        context?.let { viewModel.getAllNotes(it) }
        viewModel.notes.observe(viewLifecycleOwner) {
            adapter.setNoteList(it)
            recyclerView.also { recycler ->
                recycler.adapter = adapter
            }
        }
    }

}