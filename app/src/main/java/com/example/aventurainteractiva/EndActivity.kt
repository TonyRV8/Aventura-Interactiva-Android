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
        // IMPORTANTE: Aplicar el tema ANTES de setContentView
        ThemeManager.applyTheme(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end)

        // Cargar el Fragment del End
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.fragment_container_end, EndFragment())
                .commit()
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.fade_out, R.anim.fade_in)
    }
}