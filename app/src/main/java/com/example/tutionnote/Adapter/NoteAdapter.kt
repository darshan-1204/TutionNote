package com.example.tutionnote.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.tutionnote.DataBase.NoteEntity
import com.example.tutionnote.R

class NoteAdapter(list: List<NoteEntity>) : RecyclerView.Adapter<NoteAdapter.NoteHolder>() {

    var list = list

    class NoteHolder(itemView: View) : ViewHolder(itemView){

        var title = itemView.findViewById<TextView>(R.id.tvTitle)
        var note = itemView.findViewById<TextView>(R.id.tvNote)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteHolder {

        return NoteHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycle_activity,parent,false))
    }

    override fun getItemCount(): Int {
        return  list.size
    }

    override fun onBindViewHolder(holder: NoteHolder, position: Int) {

        holder.title.text = list[position].title
        holder.note.text = list[position].note
    }
}