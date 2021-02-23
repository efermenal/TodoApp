package com.example.todo.ui.fragments.listnote

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.todo.R
import com.example.todo.databinding.FragmentListNoteBinding
import com.example.todo.models.Note
import com.example.todo.models.Priority
import com.example.todo.ui.fragments.MainViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ListNoteFragment : Fragment(R.layout.fragment_list_note) {

    private val viewModel: MainViewModel by activityViewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val biding = FragmentListNoteBinding.bind(view)

        biding.fabAdNote.setOnClickListener {
            findNavController().navigate(R.id.action_listNoteFragment_to_addNoteFragment)
        }

        setHasOptionsMenu(true)


    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
    }

}