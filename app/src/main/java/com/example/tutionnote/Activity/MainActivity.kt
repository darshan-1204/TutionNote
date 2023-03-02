package com.example.tutionnote.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.tutionnote.Adapter.NoteAdapter
import com.example.tutionnote.DataBase.RoomDB
import com.example.tutionnote.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = RoomDB.getInstances(this)

        var list = db.notes().getNote()

        binding.recycler.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        adapter = NoteAdapter(list)
        binding.recycler.adapter = adapter

        binding.addNote.setOnClickListener{

            var intent = Intent(this, AddNote::class.java)
            startActivity(intent)
        }
    }

    companion object{

        lateinit var adapter: NoteAdapter
        lateinit var binding: ActivityMainBinding
        lateinit var db: RoomDB

        fun update(){
            var list = db.notes().getNote()
            adapter = NoteAdapter(list)
            binding.recycler.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
            binding.recycler.adapter = adapter
        }
    }
}