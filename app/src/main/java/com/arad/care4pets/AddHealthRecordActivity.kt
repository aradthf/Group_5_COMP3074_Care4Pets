package com.arad.care4pets

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddHealthRecordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_health_record)

        val btnSave = findViewById<Button>(R.id.btn_save_health_record)

        btnSave.setOnClickListener {
            Toast.makeText(
                this,
                "Health record feature will be implemented later",
                Toast.LENGTH_SHORT
            ).show()
            finish()
        }
    }
}
