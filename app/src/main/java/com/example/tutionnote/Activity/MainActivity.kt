package com.example.tutionnote.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tutionnote.Adapter.NoteAdapter
import com.example.tutionnote.DataBase.RoomDB
import com.example.tutionnote.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var db = RoomDB.getInstances(this)

        var list = db.notes().getNote()

        binding.recycler.layoutManager = LinearLayoutManager(this)
        binding.recycler.adapter = NoteAdapter(list)


        binding.addNote.setOnClickListener{

            var intent = Intent(this, AddNote::class.java)
            startActivity(intent)
        }
    }
}