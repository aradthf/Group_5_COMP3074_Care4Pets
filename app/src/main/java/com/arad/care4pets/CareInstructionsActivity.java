package com.arad.care4pets;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CareInstructionsActivity extends AppCompatActivity {

    private CareInstructionsAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_care_instructions);
        RecyclerView recyclerView = findViewById(R.id.rvCareInstructions);

        CareInstructions care = FakeRepository.careInstructions;

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new CareInstructionsAdapter(care.getCareInstructions());
        recyclerView.setAdapter(adapter);

        EditText etInstruction = findViewById(R.id.etInstruction);
        Button btnAdd = findViewById(R.id.btnAddInstruction);

        btnAdd.setOnClickListener(v -> {
            String newInstruction = etInstruction.getText().toString();
            if(newInstruction.isEmpty()){
                Toast.makeText(this, "Please fill out form", Toast.LENGTH_SHORT).show();
                return;
            }
            adapter.addInstruction(newInstruction);
            etInstruction.setText("");
        });

        ImageButton btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> finish());
    }
}