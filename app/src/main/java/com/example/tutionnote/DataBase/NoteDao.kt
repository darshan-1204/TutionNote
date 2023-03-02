package com.example.tutionnote.DataBase

import androidx.room.*

@Dao
interface NoteDao {

    @Insert
    fun addNote(note : NoteEntity)

    @Query("SELECT * FROM tuitionNote")
    fun getNote() : List<NoteEntity>

    @Delete
    fun deleteNote(note: NoteEntity)

    @Update
    fun updateNote(note: NoteEntity)
}