package com.example.omera.roomdatabasesimpleapp

import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        val notes:List<Note>
        val db:AppDatabase= Room.databaseBuilder(this,AppDatabase::class.java,"notes")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
        notes=db.notedao().getAllNotes()
        recyclerview.layoutManager=LinearLayoutManager(this)
        recyclerview.adapter=NoteAdapter(notes,this@MainActivity)

        fab.setOnClickListener {
            val intent=Intent(this,CreateNote::class.java)
            startActivity(intent)
        }
    }
}
