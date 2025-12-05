package com.arad.care4pets;

public class Pet {

    private int id;
    private String name;
    private String species;
    private int age;
    private String notes;

    public Pet(int id, String name, String species, int age, String notes) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.age = age;
        this.notes = notes;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    public String getNotes() {
        return notes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
