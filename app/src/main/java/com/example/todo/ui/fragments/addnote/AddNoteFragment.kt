package com.example.todo.ui.fragments.addnote

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.todo.R
import com.example.todo.databinding.FragmentAddNoteBinding
import com.example.todo.models.Note
import com.example.todo.models.Priority
import com.example.todo.ui.fragments.MainViewModel
import com.example.todo.ui.fragments.common.CustomOnItemSelected
import com.google.android.material.snackbar.Snackbar


class AddNoteFragment() : Fragment(R.layout.fragment_add_note) {

    private val viewModel : MainViewModel by activityViewModels()
    private var _binding : FragmentAddNoteBinding? = null
    private val binding : FragmentAddNoteBinding
        get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentAddNoteBinding.bind(view)
        setHasOptionsMenu(true)
        binding.spPriorityAdd.onItemSelectedListener = CustomOnItemSelected(requireContext())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.add_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.menu_add){
            saveNote()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun saveNote() {
        val title = binding.titleEtAdd.text.toString()
        val description = binding.descriptionEtAdd.text.toString()
        val priority = binding.spPriorityAdd.selectedItem.toString()
        if (description.isEmpty() || title.isEmpty()){
            Snackbar.make(this.requireView(), getString(R.string.message_empty_fields), Snackbar.LENGTH_SHORT).show()
        }else{
            viewModel.insertNote(Note(0,
                title,
                description,
                Priority.valueOf(priority.toUpperCase())
            ))
            Snackbar.make(this.requireView(), getString(R.string.note_saved), Snackbar.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addNoteFragment_to_listNoteFragment)
        }

    }


    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }


}