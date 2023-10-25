package com.example.teste

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        }

    fun calculateBMI(view: View) {
        val editTextHeight = findViewById<EditText>(R.id.editTextHeight)
        val editTextWeight = findViewById<EditText>(R.id.editTextWeight)

        val heightStr = editTextHeight.text.toString()
        val weightStr = editTextWeight.text.toString()

        if (heightStr.isEmpty() || weightStr.isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            return
        }

        val height = heightStr.toDouble()
        val weight = weightStr.toDouble()

        val bmi = weight / (height * height)

        val result: String = when {
            bmi < 18.5 -> "Abaixo do peso"
            bmi < 24.9 -> "Peso normal"
            bmi < 29.9 -> "Sobrepeso"
            else -> "Obeso"
        }

        Toast.makeText(this, "Seu IMC é %.2f".format(bmi) + "\n$result", Toast.LENGTH_SHORT).show()

    }
        }