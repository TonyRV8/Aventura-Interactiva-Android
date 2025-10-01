package com.example.aventurainteractiva

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.aventurainteractiva.fragments.NetherFragment

/**
 * NetherActivity - Representa el Nether (Infierno)
 * Segundo nivel de la jerarquía de navegación
 */
class NetherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nether)

        // Configurar botón de regreso personalizado
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "🔥 The Nether"

        // Cargar el Fragment del Nether
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.fragment_container_nether, NetherFragment())
                .commit()
        }
    }

    /**
     * Método para viajar al End con animación de portal especial
     */
    fun travelToEnd() {
        val intent = Intent(this, EndActivity::class.java)
        startActivity(intent)
        // Animación más dramática para el portal del End
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
    }

    /**
     * Regresar al Overworld con animación inversa
     */
    override fun onSupportNavigateUp(): Boolean {
        finish()
        overridePendingTransition(R.anim.portal_exit, R.anim.portal_enter)
        return true
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.portal_exit, R.anim.portal_enter)
    }
}