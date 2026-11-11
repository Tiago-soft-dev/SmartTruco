package com.example.smarttruco

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.smarttruco.databinding.ActivityMainBinding
import com.example.smarttruco.databinding.ActivityMainBinding.inflate

class MainActivity : AppCompatActivity() {

    var jog1Vit: Int = 0
    var jog2Vit: Int = 0
    var novoNome1: String? = null
    var novoNome2: String? = null

    var jog1Pts: Int = 0
    var jog2Pts: Int = 0

    //declarando o binding
    private lateinit var binding: ActivityMainBinding

    //tratando o retorno de dados atraves do registerForActivityResult
    val pegarNomesLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val data = result.data

            novoNome1 = data?.getStringExtra("NOME_JOG_1")
            novoNome2 = data?.getStringExtra("NOME_JOG_2")

            binding.tvJog1.text = novoNome1
            binding.tvJog2.text = novoNome2
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btInfNom.setOnClickListener {
            abrirTelaInformarNomes()
        }
        binding.btHistVit.setOnClickListener {
            abrirTelaHistoricoJogadas()
        }
        binding.tvJog1Pts.text = jog1Pts.toString()
        binding.tvJog2Pts.text = jog2Pts.toString()

        //chamada funcao zerarHistorico
        binding.btZerHis.setOnClickListener {
            zerarHistorico()
        }


        binding.btJog11.setOnClickListener {
            if (jog1Pts < 12) {
                jog1Pts += 1
                binding.tvJog1Pts.text = jog1Pts.toString()
                verificarFimDeJogo()
            }
        }

        binding.btJog13.setOnClickListener {
            if (jog1Pts < 12) {
                jog1Pts += 3
                binding.tvJog1Pts.text = jog1Pts.toString()
                verificarFimDeJogo()
            }
        }
        binding.btJog16.setOnClickListener {
            if (jog1Pts < 12) {
                jog1Pts += 6
                binding.tvJog1Pts.text = jog1Pts.toString()
                verificarFimDeJogo()
            }

        }
        binding.btJog19.setOnClickListener {
            if (jog1Pts < 12) {
                jog1Pts += 9
                binding.tvJog1Pts.text = jog1Pts.toString()
                verificarFimDeJogo()
            }

        }
        binding.btJog112.setOnClickListener {
            if (jog1Pts < 12) {
                jog1Pts += 12
                binding.tvJog1Pts.text = jog1Pts.toString()
                verificarFimDeJogo()
            }
        }

        //botoes de pontos do jogador 2
        binding.btJog21.setOnClickListener {
            if (jog2Pts < 12) {
                jog2Pts += 1
                binding.tvJog2Pts.text = jog2Pts.toString()
                verificarFimDeJogo()
            }
        }

        binding.btJog23.setOnClickListener {
            if (jog2Pts < 12) {
                jog2Pts += 3
                binding.tvJog2Pts.text = jog2Pts.toString()
                verificarFimDeJogo()
            }
        }
        binding.btJog26.setOnClickListener {
            if (jog2Pts < 12) {
                jog2Pts += 6
                binding.tvJog2Pts.text = jog2Pts.toString()
                verificarFimDeJogo()
            }
        }
        binding.btJog29.setOnClickListener {
            if (jog2Pts < 12) {
                jog2Pts += 9
                binding.tvJog2Pts.text = jog2Pts.toString()
                verificarFimDeJogo()
            }
        }
        binding.btJog212.setOnClickListener {
            if (jog2Pts < 12) {
                jog2Pts += 12
                binding.tvJog2Pts.text = jog2Pts.toString()
                verificarFimDeJogo()
            }
        }

    }

    fun abrirTelaInformarNomes() {
        val intent = Intent(this, informarNomes::class.java)
        //startActivity(intent)
        pegarNomesLauncher.launch(intent)
    }

    fun abrirTelaHistoricoJogadas() {
        val intent = Intent(this, HistoricoJogadas::class.java).apply {
            putExtra("NOME_JOG_1", novoNome1)
            putExtra("NOME_JOG_2", novoNome2)
            putExtra("JOG_1_VIT", jog1Vit)
            putExtra("JOG_2_VIT", jog2Vit)
        }
        startActivity(intent)
    }

    //funcao zerarHistorico
    fun zerarHistorico() {
        jog1Vit = 0
        jog2Vit = 0
        jog1Pts = 0
        jog2Pts = 0
        binding.tvJog1Pts.text = jog1Pts.toString()
        binding.tvJog2Pts.text = jog2Pts.toString()

        Toast.makeText(this, "Histórico e placar zerados!", Toast.LENGTH_SHORT).show()
    }

    fun verificarFimDeJogo() {
        if (jog1Pts >= 12) {
            jog1Vit += 1
            val alertDialog = AlertDialog.Builder(this)
                .setTitle("Fim de Jogo!")
                .setMessage("O Jogador 1 venceu a partida!")
                .setCancelable(false)
                .setPositiveButton("Nova Partida") { dialog, which ->
                    // Reseta os pontos e atualiza a tela
                    jog1Pts = 0
                    jog2Pts = 0
                    binding.tvJog1Pts.text = jog1Pts.toString()
                    binding.tvJog2Pts.text = jog2Pts.toString()
                }
                .create()

            alertDialog.show()

        } else if (jog2Pts >= 12) {
            jog2Vit += 1
            val alertDialog = AlertDialog.Builder(this)
                .setTitle("Fim de Jogo!")
                .setMessage("O Jogador 2 venceu a partida!")
                .setCancelable(false)
                .setPositiveButton("Nova Partida") { dialog, which ->
                    // Reseta os pontos e atualiza a tela
                    jog1Pts = 0
                    jog2Pts = 0
                    binding.tvJog1Pts.text = jog1Pts.toString()
                    binding.tvJog2Pts.text = jog2Pts.toString()
                }
                .create()

            alertDialog.show()
        }
    }


}