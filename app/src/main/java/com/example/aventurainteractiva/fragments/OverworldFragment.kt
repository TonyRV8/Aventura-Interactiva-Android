package com.example.aventurainteractiva.fragments

import android.app.AlertDialog
import android.content.Intent
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
import com.example.aventurainteractiva.EndActivity
import com.example.aventurainteractiva.MainActivity
import com.example.aventurainteractiva.NetherActivity
import com.example.aventurainteractiva.R
import com.example.aventurainteractiva.models.PointOfInterest

/**
 * Fragment del Overworld - Contiene los puntos de interés del mundo superior
 */
class OverworldFragment : Fragment() {

    // Lista de puntos de interés del Overworld
    private val pointsOfInterest = listOf(
        PointOfInterest(
            "🌳 Bosque de Robles",
            "Un denso bosque lleno de árboles de roble, perfecto para obtener madera.",
            "🌳",
            "Los robles son el árbol más común en Minecraft y existen desde la versión Alpha."
        ),
        PointOfInterest(
            "⛰️ Montañas",
            "Altas montañas con nieve en las cimas, hogar de cabras y minerales raros.",
            "⛰️",
            "Las montañas pueden alcanzar hasta Y=256 de altura desde la actualización 1.18."
        ),
        PointOfInterest(
            "🌊 Océano Profundo",
            "Vastos océanos con monumentos submarinos y tesoros escondidos.",
            "🌊",
            "Los océanos contienen monumentos oceánicos protegidos por guardianes."
        ),
        PointOfInterest(
            "🏰 Aldea",
            "Una aldea habitada por aldeanos que comercian recursos.",
            "🏰",
            "Las aldeas pueden tener diferentes estilos según el bioma donde se generen."
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_overworld, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configurar botones de puntos de interés
        view.findViewById<Button>(R.id.btn_poi_1)?.setOnClickListener {
            showPoiDialog(pointsOfInterest[0])
        }
        view.findViewById<Button>(R.id.btn_poi_2)?.setOnClickListener {
            showPoiDialog(pointsOfInterest[1])
        }
        view.findViewById<Button>(R.id.btn_poi_3)?.setOnClickListener {
            showPoiDialog(pointsOfInterest[2])
        }
        view.findViewById<Button>(R.id.btn_poi_4)?.setOnClickListener {
            showPoiDialog(pointsOfInterest[3])
        }

        // Cargar y animar el GIF del portal al Nether con Glide
        val imgPortalNether = view.findViewById<ImageView>(R.id.img_portal_nether)
        Glide.with(this)
            .asGif()
            .load(R.drawable.nether)
            .into(imgPortalNether)

        // Configurar click del portal al Nether
        imgPortalNether?.setOnClickListener { imageView ->
            val animation = AnimationUtils.loadAnimation(context, R.anim.portal_enter)
            imageView.startAnimation(animation)

            imageView.postDelayed({
                (activity as? MainActivity)?.travelToNether()
            }, 300)
        }

        // Configurar imagen clickeable del portal al End (PNG)
        val imgPortalEnd = view.findViewById<ImageView>(R.id.img_portal_end)
        imgPortalEnd?.setOnClickListener { imageView ->
            val animation = AnimationUtils.loadAnimation(context, R.anim.fade_in)
            imageView.startAnimation(animation)

            imageView.postDelayed({
                val intent = Intent(activity, EndActivity::class.java)
                startActivity(intent)
                activity?.overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
            }, 400)
        }
    }

    /**
     * Muestra un diálogo con información del punto de interés
     */
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