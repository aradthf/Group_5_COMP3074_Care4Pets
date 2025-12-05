package com.arad.care4pets;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button btnDashboard = findViewById(R.id.btnDashboard);
        Button btnMyPets = findViewById(R.id.btnMyPets);
        Button btnReminders = findViewById(R.id.btnReminders);
        Button btnHealthRecords = findViewById(R.id.btnHealthRecords);
        Button btnCareInstructions = findViewById(R.id.btnCareInstructions);

        btnDashboard.setOnClickListener(v -> {
        Intent intent = new Intent(MenuActivity.this, DashboardActivity.class);
        startActivity(intent);
    });

        btnMyPets.setOnClickListener(v -> {
        Intent intent = new Intent(MenuActivity.this, PetsListActivity.class);
        startActivity(intent);
    });

        btnReminders.setOnClickListener(v -> {
        Intent intent = new Intent(MenuActivity.this, RemindersActivity.class);
        startActivity(intent);
    });

        btnHealthRecords.setOnClickListener(v -> {
        Intent intent = new Intent(MenuActivity.this, HealthRecordsActivity.class);
        startActivity(intent);
    });

        btnCareInstructions.setOnClickListener(v -> {
        Intent intent = new Intent(MenuActivity.this, CareInstructionsActivity.class);
        startActivity(intent);
    });
    }
}
