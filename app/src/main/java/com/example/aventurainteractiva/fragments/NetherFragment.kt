package com.example.aventurainteractiva.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.aventurainteractiva.NetherActivity
import com.example.aventurainteractiva.R
import com.example.aventurainteractiva.models.PointOfInterest

/**
 * Fragment del Nether - Contiene los puntos de interés del infierno
 */
class NetherFragment : Fragment() {

    // Lista de puntos de interés del Nether
    private val pointsOfInterest = listOf(
        PointOfInterest(
            "🔥 Fortaleza del Nether",
            "Una enorme estructura de ladrillo rojo habitada por Blazes y Wither Skeletons.",
            "🔥",
            "Las fortalezas contienen spawners de Blazes, necesarios para llegar al End."
        ),
        PointOfInterest(
            "🍄 Bosque Carmesí",
            "Un bosque de hongos gigantes de color rojo con Piglins.",
            "🍄",
            "Los Piglins intercambian oro por objetos raros y no atacan si llevas armadura dorada."
        ),
        PointOfInterest(
            "💀 Valle de Almas",
            "Un valle oscuro lleno de arena de almas y fuego azul.",
            "💀",
            "La arena de almas te hace caminar más lento, pero puedes crear fuego azul sobre ella."
        ),
        PointOfInterest(
            "🏛️ Bastión",
            "Ruinas de una civilización Piglin con tesoros valiosos.",
            "🏛️",
            "Los bastiones pueden contener bloques de netherita antigua, el mineral más valioso."
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_nether, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configurar botones de puntos de interés
        view.findViewById<Button>(R.id.btn_poi_nether_1)?.setOnClickListener {
            showPoiDialog(pointsOfInterest[0])
        }
        view.findViewById<Button>(R.id.btn_poi_nether_2)?.setOnClickListener {
            showPoiDialog(pointsOfInterest[1])
        }
        view.findViewById<Button>(R.id.btn_poi_nether_3)?.setOnClickListener {
            showPoiDialog(pointsOfInterest[2])
        }
        view.findViewById<Button>(R.id.btn_poi_nether_4)?.setOnClickListener {
            showPoiDialog(pointsOfInterest[3])
        }

        // Cargar y animar el GIF con Glide
        val imgBackOverworld = view.findViewById<ImageView>(R.id.img_back_overworld)
        Glide.with(this)
            .asGif()
            .load(R.drawable.nether)
            .into(imgBackOverworld)

        // Configurar click para regresar al Overworld
        imgBackOverworld?.setOnClickListener { imageView ->
            val animation = AnimationUtils.loadAnimation(context, R.anim.portal_exit)
            imageView.startAnimation(animation)

            imageView.postDelayed({
                activity?.finish()
                activity?.overridePendingTransition(R.anim.portal_exit, R.anim.portal_enter)
            }, 300)
        }
    }

    private fun showPoiDialog(poi: PointOfInterest) {
        val dialogView = layoutInflater.inflate(R.layout.dialog_poi_info, null)

        dialogView.findViewById<TextView>(R.id.dialog_poi_title)?.text = poi.name
        dialogView.findViewById<TextView>(R.id.dialog_poi_description)?.text = poi.description
        dialogView.findViewById<TextView>(R.id.dialog_poi_fun_fact)?.text = "💡 ${poi.funFact}"

        AlertDialog.Builder(requireContext())
            .setView(dialogView)
            .setPositiveButton("Cerrar", null)
            .create()
            .show()
    }
}