package com.example.parcial1camilosilva

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var nombreAlumno: EditText
    private lateinit var buttonIngresarAlumno: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nombreAlumno = findViewById(R.id.editTextNombreAlumno)
        buttonIngresarAlumno = findViewById(R.id.buttonIngresar)

        val preferences = getSharedPreferences("IngresarAlumnoPref", MODE_PRIVATE)
        val userNamePref = preferences.getString("name", "")

        if (!userNamePref.isNullOrEmpty()) {

            val intent = Intent(this, ListAlumnos::class.java)
            startActivity(intent)
        }

        buttonIngresarAlumno.setOnClickListener {

            if (nombreAlumno.text.toString().isNullOrEmpty()) {
                Toast.makeText(this, "Debe escribir el nombre del alumno", Toast.LENGTH_SHORT).show()
            } else {
                val nameAlumno = nombreAlumno.text.toString()

                val preferences = getSharedPreferences("IngresarAlumnoPref", MODE_PRIVATE)
                val editor = preferences.edit()
                editor.putString("name", nameAlumno)
                editor.apply()
                val intent = Intent(this, ListAlumnos::class.java)
                intent.putExtra("name", nameAlumno)
                startActivity(intent)
                finish()
                Toast.makeText(this, "Se ha agregado a $nameAlumno", Toast.LENGTH_SHORT).show()
            }
        }
    }
}