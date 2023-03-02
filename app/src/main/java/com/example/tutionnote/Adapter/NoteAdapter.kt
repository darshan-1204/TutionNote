package com.example.tutionnote.Adapter

import android.app.Dialog
import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.tutionnote.Activity.MainActivity
import com.example.tutionnote.DataBase.NoteEntity
import com.example.tutionnote.DataBase.RoomDB
import com.example.tutionnote.R
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class NoteAdapter(list: List<NoteEntity>) : RecyclerView.Adapter<NoteAdapter.NoteHolder>() {

    lateinit var context : Context
    var list = list

    class NoteHolder(itemView: View) : ViewHolder(itemView){

        var title = itemView.findViewById<TextView>(R.id.tvTitle)
        var note = itemView.findViewById<TextView>(R.id.tvNote)
        var delete = itemView.findViewById<ImageView>(R.id.delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteHolder {

        context = parent.context

        return NoteHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycle_activity,parent,false))
    }

    override fun getItemCount(): Int {
        return  list.size
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: NoteHolder, position: Int) {

        var db = RoomDB.getInstances(context)

        holder.title.text = list[position].title
        holder.note.text = list[position].note

//        For Deleting Specific data
        holder.delete.setOnClickListener {

            db.notes().deleteNote(list[position])
            MainActivity.update()
        }

//        To Update the Data
        holder.itemView.setOnClickListener{

            var dialog = Dialog(context)
            dialog.setContentView(R.layout.data_update)

            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a")
            val current = LocalDateTime.now().format(formatter)

            var edtTitle = dialog.findViewById<EditText>(R.id.edtTitle)
            var edtNote = dialog.findViewById<EditText>(R.id.edtNote)
            var btnUpdate = dialog.findViewById<CardView>(R.id.btnUpdate)

            edtTitle.setText(list[position].title)
            edtNote.setText(list[position].note)
            dialog.show()

            btnUpdate.setOnClickListener {

                var data = NoteEntity(edtTitle.text.toString(),edtNote.text.toString(),1,current)
                data.id = list[position].id

                db.notes().updateNote(data)
                dialog.dismiss()
                MainActivity.update()
            }

        }
    }
}