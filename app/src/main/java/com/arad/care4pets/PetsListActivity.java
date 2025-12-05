package com.arad.care4pets;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class PetsListActivity extends AppCompatActivity {

    private PetAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pets_list);

        RecyclerView recycler = findViewById(R.id.rvPets);
        FloatingActionButton fabAdd = findViewById(R.id.fabAddPet);
        ImageButton btnBack = findViewById(R.id.btnBackMenu);
        Button btnCareInstructions = findViewById(R.id.btnCareInstructions);

        adapter = new PetAdapter(
                FakeRepository.pets,
        pet -> {
        Intent intent = new Intent(PetsListActivity.this, PetProfileActivity.class);
        intent.putExtra("petId", pet.getId());
        startActivity(intent);
    }
        );

        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(adapter);

        fabAdd.setOnClickListener(v ->
        startActivity(new Intent(PetsListActivity.this, AddPetActivity.class))
        );

        btnBack.setOnClickListener(v -> finish());
        btnCareInstructions.setOnClickListener(v -> {
            Intent intent = new Intent(this, CareInstructionsActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.setPets(FakeRepository.pets);
    }
}
