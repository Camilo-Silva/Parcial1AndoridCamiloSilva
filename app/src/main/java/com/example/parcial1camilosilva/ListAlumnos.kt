package com.example.parcial1camilosilva

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListAlumnos : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_alumnos)

        recyclerView = findViewById(R.id.recyclerViewAlumnos)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = Adapter(applicationContext)
        recyclerView.adapter = adapter

        val preferences = getSharedPreferences("IngresarAlumnoPref", MODE_PRIVATE)
        val userNamePref = preferences?.getString("name","") ?: ""

        adapter.submitList(getListadoAlumnos(userNamePref))
        getListadoAlumnos(userNamePref)

        adapter.onItemClickListener = {alumno ->
            val intent = Intent(this, DetailAlumnos::class.java)
            intent.putExtra("name", alumno.name)
            intent.putExtra("age", alumno.age.toString())
            intent.putExtra("url", alumno.url)
            startActivity(intent)
        }
    }

    private fun getListadoAlumnos(userNamePref: String): MutableList<Alumno> {
        return mutableListOf(
            Alumno(1, userNamePref,32, "https://liquipedia.net/commons/images/f/f0/Incognito_Logo_V3_Black_Border.png"),
            Alumno(2, "Ronaldo Nazario", 31,"https://fcb-abj-pre.s3.amazonaws.com/img/jugadors/764_ronaldo.jpg"),
            Alumno(3, "Lionel Messi", 36,"https://ongpng.com/wp-content/uploads/2023/01/17.Messi_675x970-2.png"),
            Alumno(4, "Albert Einstein", 36,"https://www.pngall.com/wp-content/uploads/5/Albert-Einstein-PNG-Images.png"),
            Alumno(5, "Cristiano Ronaldo", 36,"https://ongpng.com/wp-content/uploads/2023/01/10.ronaldo_504x693-2.png"),
            Alumno(6, "Muñeco Gallardo", 36,"https://www.radioeme.com/wp-content/uploads/2023/01/MARCELO-GALLARDO.png"),
            Alumno(7, "Checo Perez", 36,"https://percepcionpublica.com/wp-content/uploads/2020/09/checorbr.png"),
            Alumno(8, "Enzo Perez", 36,"https://upload.wikimedia.org/wikipedia/commons/e/e5/Enzo_perez_river_crop1575927494033.jpg_423682103.jpg"),
            Alumno(9, "Homero Simpson", 36,"https://upload.wikimedia.org/wikipedia/en/0/02/Homer_Simpson_2006.png"),
            Alumno(10, "Goku Kakaroto", 36,"https://static.wikia.nocookie.net/crossover-reality/images/8/81/Goku_-Adult-_dise%C3%B1o_DBS_Broly.png")
        )
    }
}