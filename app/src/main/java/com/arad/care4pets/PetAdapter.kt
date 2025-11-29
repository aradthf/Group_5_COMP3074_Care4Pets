package com.arad.care4pets

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PetAdapter(
    pets: List<Pet>,
    private val onItemClick: (Pet) -> Unit
) : RecyclerView.Adapter<PetAdapter.PetViewHolder>() {

    var pets: List<Pet> = pets
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class PetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tvPetName)
        val tvSpecies: TextView = itemView.findViewById(R.id.tvPetSpecies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pet, parent, false)
        return PetViewHolder(view)
    }

    override fun onBindViewHolder(holder: PetViewHolder, position: Int) {
        val pet = pets[position]
        holder.tvName.text = pet.name
        holder.tvSpecies.text = "${pet.species}, ${pet.age} years"
        holder.itemView.setOnClickListener { onItemClick(pet) }
    }

    override fun getItemCount(): Int = pets.size
}
