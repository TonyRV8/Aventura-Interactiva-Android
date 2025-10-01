package com.example.aventurainteractiva

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.aventurainteractiva.fragments.OverworldFragment

/**
 * MainActivity - Representa el Overworld (Mundo Superior)
 * Primer nivel de la jerarquía de navegación
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Cargar el Fragment del Overworld al iniciar
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.fragment_container_overworld, OverworldFragment())
                .commit()
        }
    }

    /**
     * Método para viajar al Nether con animación de portal
     * Se llama desde el Fragment cuando el usuario interactúa con el portal
     */
    fun travelToNether() {
        val intent = Intent(this, NetherActivity::class.java)
        startActivity(intent)
        // Aplicar animación personalizada de portal
        overridePendingTransition(R.anim.portal_enter, R.anim.portal_exit)
    }
}