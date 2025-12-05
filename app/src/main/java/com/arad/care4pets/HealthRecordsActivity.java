package com.arad.care4pets;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HealthRecordsActivity extends AppCompatActivity {

    private HealthRecordAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_records);

        RecyclerView recycler = findViewById(R.id.rvHealthRecords);
        FloatingActionButton btnAddHealthRecord = findViewById(R.id.fabAddHealthRecord);
        ImageButton btnBack = findViewById(R.id.btnBack);

        adapter = new HealthRecordAdapter(
                FakeRepository.records,
                record ->{
                    Intent intent = new Intent(HealthRecordsActivity.this, HealthRecordDetails.class);
                    startActivity(intent);
                }
        );

        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(adapter);

        btnAddHealthRecord.setOnClickListener( v ->{
            startActivity(new Intent(HealthRecordsActivity.this, AddHealthRecordActivity.class));
        });
//        btnAddHealthRecord.setOnClickListener(v -> {
//        Intent intent = new Intent(HealthRecordsActivity.this, AddHealthRecordActivity.class);
//        startActivity(intent);
//    });



        btnBack.setOnClickListener(v -> finish());
    }

    @Override
    protected void onResume(){
        super.onResume();
        adapter.setRecords(FakeRepository.records);
    }
}
