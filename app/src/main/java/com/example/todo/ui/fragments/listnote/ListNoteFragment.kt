package com.example.todo.ui.fragments.listnote

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.todo.R
import com.example.todo.databinding.FragmentListNoteBinding

class ListNoteFragment : Fragment(R.layout.fragment_list_note) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val biding = FragmentListNoteBinding.bind(view)

        biding.fabAdNote.setOnClickListener {
            findNavController().navigate(R.id.action_listNoteFragment_to_addNoteFragment)
        }
    }
}