package com.example.todo.ui.fragments.listnote

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todo.R
import com.example.todo.databinding.FragmentListNoteBinding
import com.example.todo.models.Note
import com.example.todo.models.Priority
import com.example.todo.ui.fragments.MainViewModel
import com.example.todo.ui.fragments.listnote.adapter.AdapterListNote
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import timber.log.Timber

class ListNoteFragment : Fragment(R.layout.fragment_list_note) {

    private var _binding : FragmentListNoteBinding? = null
    private val binding : FragmentListNoteBinding
        get() = _binding!!
    
    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var adapterNotes : AdapterListNote
    

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentListNoteBinding.bind(view)

        binding.fabAdNote.setOnClickListener {
            findNavController().navigate(R.id.action_listNoteFragment_to_addNoteFragment)
        }

        setHasOptionsMenu(true)
        init()

        viewModel.notesList.observe(viewLifecycleOwner, Observer {notes ->
            Timber.d(notes.toString())
            adapterNotes.differ.submitList(notes)

        } )

    }



    private fun init() {
        adapterNotes = AdapterListNote()
        binding.rvNotes.apply {
            adapter = adapterNotes
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(activity)
        }
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
    }

}