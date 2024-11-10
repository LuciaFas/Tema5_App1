package com.example.tema5_app1

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tema5_app1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {
    private lateinit var comidaAdapter: ComidaAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var itemDecoration: DividerItemDecoration

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        comidaAdapter = ComidaAdapter(getComida(), this)
        linearLayoutManager = LinearLayoutManager(this)
        itemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)

        binding.recycler.apply {
            layoutManager = linearLayoutManager
            adapter = comidaAdapter
            addItemDecoration(itemDecoration)
        }

        setContentView(binding.root)
    }

    private fun getComida():MutableList<Comida> {
        val comida = mutableListOf<Comida>()

        val pizza = Comida("Pizza", "Italia", "https://upload.wikimedia.org/wikipedia/commons/9/91/Pizza-3007395.jpg",
            "https://es.wikipedia.org/wiki/Pizza")
        val paella = Comida("Paella", "España", "https://upload.wikimedia.org/wikipedia/commons/4/4e/Paella_kamilo.jpg",
            "https://es.wikipedia.org/wiki/Paella")
        val kebab = Comida("Kebab", "Turquia", "https://upload.wikimedia.org/wikipedia/commons/1/17/An_Arab_kebab.jpg",
            "https://es.wikipedia.org/wiki/Kebab")
        val hamburguesa = Comida("Hamburguesa", "Estados Unidos", "https://upload.wikimedia.org/wikipedia/commons/d/dd/Hamburguesas_ElCorral.jpg",
            "https://es.wikipedia.org/wiki/Hamburguesa")
        val pasta = Comida("Pasta", "Italia", "https://upload.wikimedia.org/wikipedia/commons/2/2e/Spaghetti_with_anchovies_%28356534448%29.jpg",
            "https://es.wikipedia.org/wiki/Pasta")

        comida.add(pizza)
        comida.add(paella)
        comida.add(kebab)
        comida.add(hamburguesa)
        comida.add(pasta)

        return comida
    }

    override fun onClick(comida: Comida) {
        val intent = Intent(this, Web_Activity::class.java)
        intent.putExtra("comida_url", comida.url)
        startActivity(intent)
    }
}