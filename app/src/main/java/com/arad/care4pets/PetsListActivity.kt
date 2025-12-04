package com.arad.care4pets

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class PetsListActivity : AppCompatActivity() {

    private lateinit var adapter: PetAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pets_list)

        val recycler = findViewById<RecyclerView>(R.id.rvPets)
        val fabAdd = findViewById<FloatingActionButton>(R.id.fabAddPet)
        val btnBack = findViewById<ImageButton>(R.id.btnBackMenu)

        adapter = PetAdapter(FakeRepository.pets) { pet ->
            val intent = Intent(this, PetProfileActivity::class.java)
            intent.putExtra("petId", pet.id)
            startActivity(intent)
        }

        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter

        fabAdd.setOnClickListener {
            startActivity(Intent(this, AddPetActivity::class.java))
        }

        btnBack.setOnClickListener {
            finish()
        }
    }

    override fun onResume() {
        super.onResume()
        adapter.pets = FakeRepository.pets
    }
}
