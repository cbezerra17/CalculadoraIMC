package com.example.meuprimeiroprojeto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalc: Button = findViewById(R.id.btnCalc)
        val edtPeso: EditText = findViewById(R.id.digPeso)
        val edtAlt: EditText = findViewById(R.id.digAlt)

        btnCalc.setOnClickListener {
            val pesoStr = edtPeso.text.toString()
            val altStr = edtAlt.text.toString()

            if (pesoStr.isNotEmpty() && altStr.isNotEmpty()) {
                val peso: Float = pesoStr.toFloat()
                val altura: Float = altStr.toFloat()

                val alturaFinal: Float = altura * altura
                val imc: Float = peso / alturaFinal

                val intent = Intent(this, ResaultActivity::class.java)
                    .apply {
                        putExtra("PARAMETROINTENT_IMC", imc)
                    }

                startActivity(intent)
            } else {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_LONG).show()
            }




        }
    }
}