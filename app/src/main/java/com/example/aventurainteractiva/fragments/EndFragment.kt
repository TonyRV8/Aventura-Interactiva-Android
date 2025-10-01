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
import com.example.aventurainteractiva.R
import com.example.aventurainteractiva.models.PointOfInterest

/**
 * Fragment del End - Contiene los puntos de interés del fin
 */
class EndFragment : Fragment() {

    // Lista de puntos de interés del End
    private val pointsOfInterest = listOf(
        PointOfInterest(
            "🐉 Isla Principal",
            "La isla central donde habita el Ender Dragon, el jefe final del juego.",
            "🐉",
            "El Ender Dragon fue el primer jefe añadido a Minecraft en la versión 1.0."
        ),
        PointOfInterest(
            "🗼 Torres de Obsidiana",
            "Altas torres con cristales que curan al Ender Dragon.",
            "🗼",
            "Debes destruir todos los cristales del End antes de poder derrotar al dragón."
        ),
        PointOfInterest(
            "🌃 Ciudades del End",
            "Estructuras flotantes con los mejores tesoros del juego.",
            "🌃",
            "Las ciudades del End contienen élitros, que te permiten volar."
        ),
        PointOfInterest(
            "🚢 Barco del End",
            "Naves flotantes en las islas exteriores con cofres de tesoro.",
            "🚢",
            "Los barcos del End son la única fuente garantizada de élitros en el juego."
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_end, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configurar botones de puntos de interés
        view.findViewById<Button>(R.id.btn_poi_end_1)?.setOnClickListener {
            showPoiDialog(pointsOfInterest[0])
        }
        view.findViewById<Button>(R.id.btn_poi_end_2)?.setOnClickListener {
            showPoiDialog(pointsOfInterest[1])
        }
        view.findViewById<Button>(R.id.btn_poi_end_3)?.setOnClickListener {
            showPoiDialog(pointsOfInterest[2])
        }
        view.findViewById<Button>(R.id.btn_poi_end_4)?.setOnClickListener {
            showPoiDialog(pointsOfInterest[3])
        }

        // Configurar imagen clickeable para regresar al Overworld (end2.png)
        val imgBackOverworld = view.findViewById<ImageView>(R.id.img_back_overworld_end)
        imgBackOverworld?.setOnClickListener { imageView ->
            val animation = AnimationUtils.loadAnimation(context, R.anim.fade_out)
            imageView.startAnimation(animation)

            imageView.postDelayed({
                activity?.finish()
                activity?.overridePendingTransition(R.anim.fade_out, R.anim.fade_in)
            }, 400)
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