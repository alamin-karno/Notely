package com.alaminkarno.notely.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.alaminkarno.notely.R
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainFragment : Fragment() {

    lateinit var controller : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        controller = Navigation.findNavController(view)

        val button = view.findViewById<FloatingActionButton>(R.id.add_note_fav_button)

        button.setOnClickListener {
            controller.navigate(R.id.action_mainFragment_to_addFragment)
        }

    }

}