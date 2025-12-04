package com.arad.care4pets

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddPetActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_pet)

        val etName = findViewById<EditText>(R.id.etPetName)
        val etSpecies = findViewById<EditText>(R.id.etPetSpecies)
        val etAge = findViewById<EditText>(R.id.etPetAge)
        val etNotes = findViewById<EditText>(R.id.etPetNotes)
        val btnSave = findViewById<Button>(R.id.btnSavePet)

        btnSave.setOnClickListener {
            val name = etName.text.toString().trim()
            val species = etSpecies.text.toString().trim()
            val ageText = etAge.text.toString().trim()
            val notes = etNotes.text.toString().trim()

            if (name.isEmpty() || species.isEmpty() || ageText.isEmpty()) {
                Toast.makeText(this, "Please fill required fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val newId = (FakeRepository.pets.maxOfOrNull { it.id } ?: 0) + 1
            val pet = Pet(newId, name, species, ageText.toInt(), notes)
            FakeRepository.pets.add(pet)

            Toast.makeText(this, "Pet added", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}
