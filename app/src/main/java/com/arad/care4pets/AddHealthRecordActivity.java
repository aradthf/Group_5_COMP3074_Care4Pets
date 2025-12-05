package com.arad.care4pets;

import android.os.Bundle;
import android.provider.SyncStateContract;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AddHealthRecordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_health_record);

        Button btnSave = findViewById(R.id.btn_save_health_record);

//        btnSave.setOnClickListener(v -> {
//            Toast.makeText(
//                AddHealthRecordActivity.this,
//                "Health record feature will be implemented later",
//                Toast.LENGTH_SHORT
//            ).show();
//            finish();
//        });

        EditText etRecordTitle = findViewById(R.id.etRecordTitle);
        EditText etRecordDescription = findViewById(R.id.etRecordDescription);

        btnSave.setOnClickListener(v ->{
            String recordType = etRecordTitle.getText().toString();
            String description = etRecordDescription.getText().toString();

            if(recordType.isEmpty() || description.isEmpty()){
                Toast.makeText(this, "Please fill required fields" , Toast.LENGTH_SHORT).show();
                return;
            }

            int newId = 1;

            HealthRecord healthRecord = new HealthRecord(newId, recordType, description);
            FakeRepository.records.add(healthRecord);


            Toast.makeText(this, "Record Added" , Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}