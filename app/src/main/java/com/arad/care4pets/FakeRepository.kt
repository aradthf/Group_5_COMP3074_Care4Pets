
package com.arad.care4pets

object FakeRepository {

    val pets = mutableListOf(
        Pet(1, "Luna", "Dog", 3, "Allergic to chicken"),
        Pet(2, "Milo", "Cat", 2, "Needs eye drops")
    )

    val reminders = mutableListOf(
        Reminder(1, "Luna – Vet visit", "2024-12-15", "Vet"),
        Reminder(2, "Milo – Vaccination", "2025-01-05", "Vaccine")
    )
}
