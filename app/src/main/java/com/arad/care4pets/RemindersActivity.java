package com.arad.care4pets;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class RemindersActivity extends AppCompatActivity {

    private ReminderAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminders);

        RecyclerView recycler = findViewById(R.id.rvReminders);
        FloatingActionButton fabAdd = findViewById(R.id.fabAddReminder);
        ImageButton btnBack = findViewById(R.id.btnBack);

        adapter = new ReminderAdapter(FakeRepository.reminders);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(adapter);

        fabAdd.setOnClickListener(v ->
        startActivity(new Intent(RemindersActivity.this, AddReminderActivity.class))
        );

        btnBack.setOnClickListener(v -> finish());
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.setReminders(FakeRepository.reminders);
    }
}
