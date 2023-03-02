package com.example.tutionnote.DataBase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tuitionNote")
data class NoteEntity(
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "note") var note: String,
    @ColumnInfo(name = "color") var color:Int,
    @ColumnInfo(name = "date") var date:String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}