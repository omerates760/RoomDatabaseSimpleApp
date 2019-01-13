package com.example.omera.roomdatabasesimpleapp

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull

@Entity(tableName = "note_table")

data class Note(
                @ColumnInfo(name = "title")
                var title:String,
                @ColumnInfo(name = "subject")
                var subject:String,
                @ColumnInfo(name = "description")
                var description:String) {
                @PrimaryKey(autoGenerate = true)
                var noteId: Int = 0
}