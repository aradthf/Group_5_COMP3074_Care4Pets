package com.arad.care4pets;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class HealthRecordsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_records);

        Button btnAddHealthRecord = findViewById(R.id.fabAddHealthRecord);
        ImageButton btnBack = findViewById(R.id.btnBack);

        btnAddHealthRecord.setOnClickListener(v -> {
        Intent intent = new Intent(HealthRecordsActivity.this, AddHealthRecordActivity.class);
        startActivity(intent);
    });

        btnBack.setOnClickListener(v -> finish());
    }
}
