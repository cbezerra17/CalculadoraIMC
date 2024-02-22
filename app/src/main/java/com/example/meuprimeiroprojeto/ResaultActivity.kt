package com.example.meuprimeiroprojeto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResaultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resault)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val T2tvIMC = findViewById<TextView>(R.id.T2tvIMC)
        val T2tvclassificacao = findViewById<TextView>(R.id.T2tvClassificacao)

        val exibeIMC = intent.getFloatExtra("PARAMETROINTENT_IMC",0.1f)

        T2tvIMC.text = exibeIMC.toString()

        /**
         * < 18,5 = Magro
         * entre 18,5 e 24,9 = Peso adequado
         * entre 25 e 29,9 = Sobrepeso
         * entre 30 e 39,9 = Obesidade
         * > 40 = Obesidade grave
         */


        val T2Classificacao = if (exibeIMC < 18.5) {
            "Magreza"
        } else if (exibeIMC in 18.5..24.9) {
            "Peso adequado"
        } else if (exibeIMC in 25.0..29.9) {
            "Sobrepeso"
        } else if (exibeIMC in 30.0..39.9) {
            "Obesidade"
        } else {
            "Obesidade Grave"
        }

        T2tvclassificacao.text = getString(R.string.msg_imc,T2Classificacao)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }

    }
