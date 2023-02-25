package com.example.tutionnote.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tutionnote.DataBase.NoteEntity
import com.example.tutionnote.DataBase.RoomDB
import com.example.tutionnote.databinding.ActivityAddNoteBinding

class AddNote : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var db = RoomDB.getInstances(this)

        binding.back.setOnClickListener{

            var intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnSave.setOnClickListener {

            var notes = NoteEntity(binding.edtTitle.text.toString(),binding.edtNote.text.toString())
            db.notes().addNote(notes)
        }
    }
}