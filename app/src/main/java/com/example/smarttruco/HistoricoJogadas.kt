package com.example.smarttruco

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.smarttruco.databinding.ActivityHistoricoJogadasBinding

class HistoricoJogadas : AppCompatActivity() {

    var novoNome1: String? = null
    var novoNome2: String? = null
    private lateinit var binding: ActivityHistoricoJogadasBinding






    private var jog1Vit: Int = 0
    private var jog2Vit: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityHistoricoJogadasBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        novoNome1 = intent.getStringExtra("NOME_JOG_1") ?: "Jogador 1"
        novoNome2 = intent.getStringExtra("NOME_JOG_2") ?: "Jogador 2"

        binding.tvHistJog1.text = novoNome1
        binding.tvHistJog2.text = novoNome2

        binding.tvJog1Vit.text = intent.getIntExtra("JOG_1_VIT", 0).toString()
        binding.tvJog2Vit.text = intent.getIntExtra("JOG_2_VIT", 0).toString()
    }

}