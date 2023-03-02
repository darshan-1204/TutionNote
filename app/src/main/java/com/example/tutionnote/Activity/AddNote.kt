package com.example.tutionnote.Activity

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.tutionnote.DataBase.NoteEntity
import com.example.tutionnote.DataBase.RoomDB
import com.example.tutionnote.databinding.ActivityAddNoteBinding
import com.github.dhaval2404.colorpicker.MaterialColorPickerDialog
import com.github.dhaval2404.colorpicker.model.ColorShape
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class AddNote : AppCompatActivity() {

    var selectColor = 0

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var db = RoomDB.getInstances(this)

        binding.back.setOnClickListener {

            var intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
            finish()
        }


        binding.btnSave.setOnClickListener {

            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a")
            val current = LocalDateTime.now().format(formatter)

            var notes = NoteEntity(
                binding.edtTitle.text.toString(),
                binding.edtNote.text.toString(),
                selectColor,
                current
            )
            db.notes().addNote(notes)
        }

        binding.edtColor.setOnClickListener {

            MaterialColorPickerDialog
                .Builder(this)
                .setTitle("Pick Theme")
                .setColorShape(ColorShape.SQAURE)
                .setColorListener { color, colorHex ->
                    binding.edtColor.setCardBackgroundColor(color)
                    selectColor = color
                }
                .show()
        }
    }
}
