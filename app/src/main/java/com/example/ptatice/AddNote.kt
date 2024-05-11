package com.example.ptatice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ptatice.databinding.ActivityAddNoteBinding
import com.example.ptatice.databinding.ActivityMainBinding

class AddNote : AppCompatActivity() {

    private lateinit var binding: ActivityAddNoteBinding
    private lateinit var db: NotesDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = NotesDatabaseHelper(this)

        binding.saveButton.setOnClickListener{
            val title = binding.titleEditText.text.toString()
            val context = binding.contentEditText.text.toString()
            val note = Note(0, title, context)
            db.insertNote(note)
            finish()
            Toast.makeText(this, "Note Saved", Toast.LENGTH_SHORT).show()
        }

        binding.backbtn.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}

