package com.example.aventurainteractiva.models

/**
 * Modelo de datos para representar un Punto de Interés
 * Contiene información sobre elementos interactivos en cada dimensión
 */
data class PointOfInterest(
    val name: String,
    val description: String,
    val emoji: String,
    val funFact: String
)