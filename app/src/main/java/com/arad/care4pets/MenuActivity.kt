package com.arad.care4pets

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        findViewById<Button>(R.id.btnDashboard).setOnClickListener {
            startActivity(Intent(this, DashboardActivity::class.java))
        }
        findViewById<Button>(R.id.btnMyPets).setOnClickListener {
            startActivity(Intent(this, PetsListActivity::class.java))
        }
        findViewById<Button>(R.id.btnReminders).setOnClickListener {
            startActivity(Intent(this, RemindersActivity::class.java))
        }
        findViewById<Button>(R.id.btnHealthRecords).setOnClickListener {
            startActivity(Intent(this, HealthRecordsActivity::class.java))
        }
        findViewById<Button>(R.id.btnCareInstructions).setOnClickListener {
            startActivity(Intent(this, CareInstructionsActivity::class.java))
        }
    }
}
