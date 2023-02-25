package com.example.tutionnote.DataBase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDao {

    @Insert
    fun addNote(note : NoteEntity)

    @Query("SELECT * FROM tuitionNote")
    fun getNote() : List<NoteEntity>

    @Delete
    fun deleteNote(note: NoteEntity)
}