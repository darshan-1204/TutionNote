package com.example.tutionnote.DataBase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tuitionNote")
data class NoteEntity(
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "note") var note: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
