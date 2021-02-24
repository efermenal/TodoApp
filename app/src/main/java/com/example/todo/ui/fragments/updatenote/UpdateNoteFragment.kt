package com.example.todo.ui.fragments.updatenote

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.todo.R
import com.example.todo.databinding.FragmentUpdateNoteBinding
import com.example.todo.models.Note
import com.example.todo.models.Priority
import com.example.todo.ui.fragments.MainViewModel
import com.example.todo.ui.fragments.common.CustomOnItemSelected
import com.example.todo.ui.fragments.listnote.ListNoteFragment
import com.google.android.material.snackbar.Snackbar
import timber.log.Timber

class UpdateNoteFragment : Fragment(R.layout.fragment_update_note) {

    private var _binding : FragmentUpdateNoteBinding? = null
    private val binding : FragmentUpdateNoteBinding
        get() = _binding!!
    private val args : UpdateNoteFragmentArgs by navArgs()
    private val viewModel : MainViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentUpdateNoteBinding.bind(view)
        setHasOptionsMenu(true)
        loadNote()
        binding.spPriorityUpdate.onItemSelectedListener =  CustomOnItemSelected(requireContext())
    }

    private fun loadNote() {
        val note = args.argNote
        with(binding){
            titleEtUpdate.setText(note.title)
            descriptionEtUpdate.setText(note.description)
            spPriorityUpdate.setSelection(getPriorityIndex(note.priority))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.update_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menu_update_save){
            updateNote()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    private fun updateNote() {
        val title = binding.titleEtUpdate.text.toString()
        val description = binding.descriptionEtUpdate.text.toString()
        val priorityText = binding.spPriorityUpdate.selectedItem.toString().toUpperCase()

        if (title.isEmpty() || description.isEmpty()){
            Snackbar.make(requireView(), getString(R.string.message_empty_fields), Snackbar.LENGTH_SHORT).show()
            return
        }
        Timber.d("priorityText $priorityText")
        viewModel.updateNote(
            Note(args.argNote.id, title = title, description= description, priority = Priority.valueOf(priorityText))
        )

        Snackbar.make(requireView(), getString(R.string.note_updated), Snackbar.LENGTH_SHORT).show()

        findNavController().navigate(R.id.action_updateNoteFragment_to_listNoteFragment)
    }

    private fun getPriorityIndex(priority: Priority) : Int{
        return when(priority){
         Priority.HIGH -> 0
         Priority.MEDIUM -> 1
         Priority.LOW -> 2
     }
    }


}

