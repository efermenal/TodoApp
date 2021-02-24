package com.example.todo.ui.fragments.common

import android.content.Context
import android.view.View
import android.widget.AdapterView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.todo.R

class CustomOnItemSelected(private val context: Context) : AdapterView.OnItemSelectedListener {
    override fun onItemSelected(
        parent: AdapterView<*>?,
        view: View?,
        position: Int,
        id: Long
    ) {
        when(position){
            0 -> { (parent?.getChildAt(0) as TextView).setTextColor(ContextCompat.getColor(context, R.color.red))}
            1 -> { (parent?.getChildAt(0) as TextView).setTextColor(ContextCompat.getColor(context, R.color.orange))}
            2 -> { (parent?.getChildAt(0) as TextView).setTextColor(ContextCompat.getColor(context, R.color.green))}
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) { }
}