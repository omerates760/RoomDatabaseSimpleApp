package com.example.omera.roomdatabasesimpleapp

import android.arch.persistence.room.Room
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.create_note.*

class CreateNote: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_note)
        val db:AppDatabase= Room.databaseBuilder(applicationContext,AppDatabase::class.java,"notes")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
        btn_Add.setOnClickListener {
                val note:Note= Note(txt_Title.text.toString(),_txt_Subject.text.toString(),txt_description.text.toString())
                db.notedao().insertAll(note)
            startActivity(Intent(this@CreateNote,MainActivity::class.java))
            finish()
        }
    }
}