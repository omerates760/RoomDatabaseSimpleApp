package com.example.omera.roomdatabasesimpleapp

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface NoteDao {
     @Query("SELECT * FROM note_table")
     fun getAllNotes(): List<Note>

     @Insert
     fun insertAll(vararg note: Note)
}