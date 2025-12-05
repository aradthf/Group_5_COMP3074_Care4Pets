package com.arad.care4pets;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AddReminderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reminder);

        EditText etTitle = findViewById(R.id.etReminderTitle);
        EditText etType = findViewById(R.id.etReminderType);
        EditText etDate = findViewById(R.id.etReminderDate);
        Button btnSave = findViewById(R.id.btnSaveReminder);

        btnSave.setOnClickListener(v -> {
        String title = etTitle.getText().toString().trim();
        String type = etType.getText().toString().trim();
        String date = etDate.getText().toString().trim();

        if (title.isEmpty() || type.isEmpty() || date.isEmpty()) {
            Toast.makeText(this, "Fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        int newId = 1;
        if (!FakeRepository.reminders.isEmpty()) {
            int maxId = 0;
            for (Reminder r : FakeRepository.reminders) {
                if (r.getId() > maxId) {
                    maxId = r.getId();
                }
            }
            newId = maxId + 1;
        }
        FakeRepository.reminders.add(new Reminder(newId, title, date, type));
        Toast.makeText(this, "Reminder added", Toast.LENGTH_SHORT).show();
        finish();
    });
    }
}
