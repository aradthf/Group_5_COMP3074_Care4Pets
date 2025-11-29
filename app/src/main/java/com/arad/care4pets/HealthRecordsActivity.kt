package com.arad.care4pets

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class HealthRecordsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_health_records)

        val btnAddHealthRecord = findViewById<Button>(R.id.btnAddHealthRecord)
        val btnBack = findViewById<ImageButton>(R.id.btnBack)

        btnAddHealthRecord.setOnClickListener {
            startActivity(Intent(this, AddHealthRecordActivity::class.java))
        }

        btnBack.setOnClickListener {
            finish()
        }
    }
}
