package com.arad.care4pets;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AddHealthRecordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_health_record);

        Button btnSave = findViewById(R.id.btn_save_health_record);

        btnSave.setOnClickListener(v -> {
            Toast.makeText(
                AddHealthRecordActivity.this,
                "Health record feature will be implemented later",
                Toast.LENGTH_SHORT
            ).show();
            finish();
        });
    }
}