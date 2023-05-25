package com.example.parcial1camilosilva

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailAlumnos : AppCompatActivity() {

    private lateinit var textViewDetailNombre: TextView
    private lateinit var textViewDetailEdad: TextView
    private lateinit var imageDetail: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_alumnos)

        textViewDetailNombre = findViewById(R.id.textViewDetailNombre)
        textViewDetailEdad = findViewById(R.id.textViewDetailEdad)
        imageDetail = findViewById(R.id.imageViewDetail)

        val bundle = intent.extras
        val name = bundle?.getString("name","")
        val edad = bundle?.getString("age","")
        val url = bundle?.getString("url") ?: ""

        textViewDetailNombre.text = "Nombre de alumno: $name"
        textViewDetailEdad.text = "Edad: $edad"

        Glide.with(applicationContext)
            .load(url)
            .into(imageDetail)
    }
}