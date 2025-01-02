package com.alaminkarno.notely.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alaminkarno.notely.R
import com.alaminkarno.notely.model.Note

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>() {

    private var noteList = listOf<Note>()

    @SuppressLint("NotifyDataSetChanged")
    fun setContentList(noteList: List<Note>) {
        this.noteList = noteList
        notifyDataSetChanged()
    }

    inner class RecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title = view.findViewById<TextView>(R.id.list_item_title)
        val description = view.findViewById<TextView>(R.id.list_item_description)


    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerAdapter.RecyclerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_note,parent,false)
        return RecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.RecyclerViewHolder, position: Int) {
        holder.title.text = noteList[position].title
        holder.description.text = noteList[position].description
    }

    override fun getItemCount(): Int {
        return this.noteList.size
    }
}