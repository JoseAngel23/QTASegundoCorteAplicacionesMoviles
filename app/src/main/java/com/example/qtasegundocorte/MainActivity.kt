package com.example.qtasegundocorte

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
    }

    private fun calcularCuotas() {
        val valorPropiedad = findViewById<EditText>(R.id.number_valor_text).text.toString().toDouble()
        val valorPrestamo = findViewById<EditText>(R.id.number_valor_text_two).text.toString().toDouble()
        val plazo = findViewById<EditText>(R.id.valor_three).text.toString().toInt()
        val button_simular = findViewById<Button>(R.id.button_simular)

        val tasaInteresEfectivaAnual = findViewById<EditText>(R.id.number_valor_text_four).text.toString().toDouble()

        val interes = ((tasaInteresEfectivaAnual / 12)) / 100

        val cuota = (valorPrestamo * interes * Math.pow(1 + interes, plazo.toDouble())) / (Math.pow(1 + interes, plazo.toDouble()) - 1)

        val resultado = findViewById<TextView>(R.id.resultado_text)
        button_simular.setOnClickListener {
            if (valorPropiedad<70000000) {
                Toast.makeText(getApplicationContext(), "El campo del valor de la propiedad es menor a $70.000.000", Toast.LENGTH_SHORT).show();
            } else if (valorPrestamo<50000000) {
                Toast.makeText(getApplicationContext(), "El campo '¿Cuanto necesitas?' es menor a $50.000.000", Toast.LENGTH_SHORT).show();
            } else if (plazo<5 || plazo>20) {
                Toast.makeText(getApplicationContext(), "El plazo del credito es menor a 5 o mayor ", Toast.LENGTH_SHORT).show();
            } else if (tasaInteresEfectivaAnual < 12.0 || tasaInteresEfectivaAnual > 24.9) {
                Toast.makeText(getApplicationContext(), "¡Hola desde el botón!", Toast.LENGTH_SHORT).show();
            } else {
                resultado.text = "Paga cuotas de $${cuota} por mes"
                resultado.visibility = View.VISIBLE
            }
        }
    }


}