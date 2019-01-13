package com.example.omera.roomdatabasesimpleapp

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = [Note::class],version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun notedao(): NoteDao

}