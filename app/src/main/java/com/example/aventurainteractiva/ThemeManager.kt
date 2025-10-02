package com.example.aventurainteractiva

import android.content.Context
import android.content.SharedPreferences

/**
 * Clase para manejar el tema de la aplicación y persistir la preferencia del usuario
 */
object ThemeManager {
    private const val PREFS_NAME = "theme_prefs"
    private const val KEY_DARK_MODE = "is_dark_mode_enabled"

    /**
     * Guarda la preferencia del tema en SharedPreferences
     */
    fun saveDarkModePreference(context: Context, isDarkMode: Boolean) {
        val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        prefs.edit().putBoolean(KEY_DARK_MODE, isDarkMode).apply()
    }

    /**
     * Obtiene la preferencia del tema guardada
     */
    fun isDarkModeEnabled(context: Context): Boolean {
        val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return prefs.getBoolean(KEY_DARK_MODE, false) // Por defecto tema claro
    }

    /**
     * Aplica el tema según la preferencia guardada
     */
    fun applyTheme(context: Context) {
        if (isDarkModeEnabled(context)) {
            context.setTheme(R.style.Theme_AventuraInteractiva_Dark)
        } else {
            context.setTheme(R.style.Theme_AventuraInteractiva_Light)
        }
    }
}