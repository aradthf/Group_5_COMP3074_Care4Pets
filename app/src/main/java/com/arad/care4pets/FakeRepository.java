package com.arad.care4pets;

import java.util.ArrayList;
import java.util.List;

public class FakeRepository {

    public static final List<Pet> pets = new ArrayList<>();
    public static final List<Reminder> reminders = new ArrayList<>();

    public static final List<HealthRecord> records = new ArrayList<>();


    static {
        pets.add(new Pet(1, "Luna", "Dog", 3, "Allergic to chicken"));
        pets.add(new Pet(2, "Milo", "Cat", 2, "Needs eye drops"));

        reminders.add(new Reminder(1, "Luna – Vet visit", "2024-12-15", "Vet"));
        reminders.add(new Reminder(2, "Milo – Vaccination", "2025-01-05", "Vaccine"));

    }

    private FakeRepository() {
        // prevent instantiation
    }
}
