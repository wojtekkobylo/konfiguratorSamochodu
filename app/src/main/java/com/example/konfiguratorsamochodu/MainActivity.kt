package com.example.konfiguratorsamochodu

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.RadioGroup
import android.widget.SeekBar
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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val checkBoxKlima = findViewById<CheckBox>(R.id.checkKlima)
        val checkBoxSiedzenia = findViewById<CheckBox>(R.id.checkBoxSiedzenia)
        val imageView = findViewById<ImageView>(R.id.imageView)
        val buttonKonfig = findViewById<Button>(R.id.buttonKonfig)
        val textViewPodsumowanie = findViewById<TextView>(R.id.TextViewpodsumowanie)

        var rodzajAuta =""
        var autoZdjecie = R.drawable.suv

        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            autoZdjecie = when (checkedId) {
                R.id.radioSUV -> R.drawable.suv
                R.id.radioSedan -> R.drawable.sedan
                R.id.radioHatchBack -> R.drawable.hatchback
                else -> R.drawable.suv
            }

            rodzajAuta = when (checkedId) {
                R.id.radioSUV -> "SUV"
                R.id.radioSedan -> "Sedan"
                R.id.radioHatchBack -> "Hatchback"
                else -> ""
            }


            imageView.setImageResource(autoZdjecie)
        }
        buttonKonfig.setOnClickListener {
            val Klima = if (checkBoxKlima.isChecked) "+ klimatyzacja" else "- klimatyzacja"
            val Siedzenia = if (checkBoxSiedzenia.isChecked) "+ skorzane siedzenia" else "- skorzane siedzienia"


            textViewPodsumowanie.text = "Wybrana konfiguracja: $rodzajAuta, $Klima, $Siedzenia"

    }
}
}