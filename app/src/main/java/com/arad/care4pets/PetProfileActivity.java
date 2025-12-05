package com.arad.care4pets;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PetProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_profile);

        TextView tvName = findViewById(R.id.tvProfileName);
        TextView tvSpecies = findViewById(R.id.tvProfileSpecies);
        TextView tvAge = findViewById(R.id.tvProfileAge);
        TextView tvNotes = findViewById(R.id.tvProfileNotes);

        int petId = getIntent().getIntExtra("petId", -1);

        Pet pet = null;
        for (Pet p : FakeRepository.pets) {
        if (p.getId() == petId) {
            pet = p;
            break;
        }
    }

        if (pet != null) {
            tvName.setText(pet.getName());
            tvSpecies.setText("Species: " + pet.getSpecies());
            tvAge.setText("Age: " + pet.getAge() + " years");
            String notes = pet.getNotes() != null ? pet.getNotes().trim() : "";
            tvNotes.setText(!notes.isEmpty() ? notes : "No special notes");
        }
    }
}
