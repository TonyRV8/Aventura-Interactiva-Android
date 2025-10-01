package com.example.aventurainteractiva

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.aventurainteractiva.fragments.EndFragment

/**
 * EndActivity - Representa el End (El Fin)
 * Tercer nivel (final) de la jerarquía de navegación
 */
class EndActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end)

        // Configurar acción de regreso
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "🌌 The End"

        // Cargar el Fragment del End
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.fragment_container_end, EndFragment())
                .commit()
        }
    }

    /**
     * Regresar al Nether con animación
     */
    override fun onSupportNavigateUp(): Boolean {
        finish()
        overridePendingTransition(R.anim.fade_out, R.anim.fade_in)
        return true
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.fade_out, R.anim.fade_in)
    }
}