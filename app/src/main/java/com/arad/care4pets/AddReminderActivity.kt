package com.arad.care4pets

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddReminderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_reminder)

        val etTitle = findViewById<EditText>(R.id.etReminderTitle)
        val etType = findViewById<EditText>(R.id.etReminderType)
        val etDate = findViewById<EditText>(R.id.etReminderDate)
        val btnSave = findViewById<Button>(R.id.btnSaveReminder)

        btnSave.setOnClickListener {
            val title = etTitle.text.toString().trim()
            val type = etType.text.toString().trim()
            val date = etDate.text.toString().trim()

            if (title.isEmpty() || type.isEmpty() || date.isEmpty()) {
                Toast.makeText(this, "Fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val newId = (FakeRepository.reminders.maxOfOrNull { it.id } ?: 0) + 1
            FakeRepository.reminders.add(Reminder(newId, title, date, type))
            Toast.makeText(this, "Reminder added", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}
