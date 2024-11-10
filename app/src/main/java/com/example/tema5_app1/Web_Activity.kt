package com.example.tema5_app1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tema5_app1.databinding.ActivityMainBinding
import com.example.tema5_app1.databinding.ActivityWebBinding

class Web_Activity : AppCompatActivity() {
    private lateinit var binding: ActivityWebBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityWebBinding.inflate(layoutInflater)

        val url = intent.getStringExtra("comida_url")

        url?.let {
            binding.webView.loadUrl(it)
        }

        setContentView(R.layout.activity_web)
    }
}