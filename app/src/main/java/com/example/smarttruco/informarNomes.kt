package com.example.smarttruco

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.smarttruco.databinding.ActivityInformarNomesBinding
import com.example.smarttruco.databinding.ActivityMainBinding
import com.example.smarttruco.databinding.ActivityMainBinding.inflate

class informarNomes : AppCompatActivity() {

    private lateinit var binding: ActivityInformarNomesBinding

    private lateinit var nomeJog1: String
    private lateinit var nomeJog2: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        //inflar o binding
        binding = ActivityInformarNomesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btInfNom.setOnClickListener {
            btnConfirmarNomes()
        }
    }

    fun btnConfirmarNomes(){
        nomeJog1 = binding.tvNomeJog1.text.toString().trim().ifBlank { "Jogador 1" }
        nomeJog2 = binding.tvNomeJog2.text.toString().trim().ifBlank { "Jogador 2" }

        val intentRetornaNomes = Intent().apply {
            putExtra("NOME_JOG_1", nomeJog1)
            putExtra("NOME_JOG_2", nomeJog2)
        }

        //define que o resultado foi OK e envia a intent
        setResult(Activity.RESULT_OK, intentRetornaNomes)

        finish()
    }
}