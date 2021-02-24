package com.example.todo.ui.fragments.listnote.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.R
import com.example.todo.databinding.ItemNoteBinding
import com.example.todo.models.Note
import com.example.todo.models.Priority
import com.example.todo.ui.fragments.listnote.ListNoteFragment
import com.example.todo.ui.fragments.listnote.ListNoteFragmentDirections
import timber.log.Timber

class AdapterListNote : RecyclerView.Adapter<AdapterListNote.ViewHolderNote>()
{

    private val itemDiffCallback = object: DiffUtil.ItemCallback<Note>(){
        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean = oldItem == newItem
    }

    val differ = AsyncListDiffer(this, itemDiffCallback)


    inner class ViewHolderNote(val bindingHolder : ItemNoteBinding) : RecyclerView.ViewHolder(bindingHolder.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderNote {
        val binding = ItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolderNote(binding)
    }

    override fun onBindViewHolder(holder: ViewHolderNote, position: Int) {

        holder.bindingHolder.itemRecycler.setOnClickListener {
           val action = ListNoteFragmentDirections.actionListNoteFragmentToUpdateNoteFragment(differ.currentList[position])
            holder.itemView.findNavController().navigate(action)
        }

        with(holder.bindingHolder){
            with(differ.currentList[position]){
                titleTv.text = title
                descriptionTv.text = description
                Timber.d("Priority is ${priority.name}")
                when(priority){
                    Priority.HIGH -> priorityCv.setCardBackgroundColor(Color.BLUE)
                    Priority.MEDIUM -> priorityCv.setCardBackgroundColor(ContextCompat.getColor(holder.itemView.context, R.color.orange))
                    Priority.LOW -> priorityCv.setCardBackgroundColor(ContextCompat.getColor(holder.itemView.context, R.color.green))
                }

            }
        }
    }

    override fun getItemCount(): Int = differ.currentList.size

}