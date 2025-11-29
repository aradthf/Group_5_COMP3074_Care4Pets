package com.arad.care4pets

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class RemindersActivity : AppCompatActivity() {

    private lateinit var adapter: ReminderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reminders)

        val recycler = findViewById<RecyclerView>(R.id.rvReminders)
        val fabAdd = findViewById<FloatingActionButton>(R.id.fabAddReminder)
        val btnBack = findViewById<ImageButton>(R.id.btnBack)

        adapter = ReminderAdapter(FakeRepository.reminders)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter

        fabAdd.setOnClickListener {
            startActivity(Intent(this, AddReminderActivity::class.java))
        }

        btnBack.setOnClickListener {
            finish()
        }
    }

    override fun onResume() {
        super.onResume()
        adapter.reminders = FakeRepository.reminders
    }
}
