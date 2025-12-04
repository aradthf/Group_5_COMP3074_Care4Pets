package com.arad.care4pets

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PetProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pet_profile)

        val tvName = findViewById<TextView>(R.id.tvProfileName)
        val tvSpecies = findViewById<TextView>(R.id.tvProfileSpecies)
        val tvAge = findViewById<TextView>(R.id.tvProfileAge)
        val tvNotes = findViewById<TextView>(R.id.tvProfileNotes)

        val petId = intent.getIntExtra("petId", -1)
        val pet = FakeRepository.pets.firstOrNull { it.id == petId }

        pet?.let {
            tvName.text = it.name
            tvSpecies.text = "Species: ${it.species}"
            tvAge.text = "Age: ${it.age} years"
            tvNotes.text = if (it.notes.isNotEmpty()) it.notes else "No special notes"
        }
    }
}
