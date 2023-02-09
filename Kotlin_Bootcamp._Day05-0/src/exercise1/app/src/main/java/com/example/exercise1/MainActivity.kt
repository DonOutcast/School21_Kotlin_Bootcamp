package com.example.exercise1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.arithmeticmodule.src.ArithmeticModuleActivity
import com.example.primesmodule.src.PrimesModuleActivity
import com.example.thermometermodule.src.ThermometerModuleActivity
import com.example.circlesmodule.src.CirclesModuleActivity
import com.example.speechmodule.SpeechModule

class MainActivity : AppCompatActivity() {
    private lateinit var circlesButton: Button
    private lateinit var primesButton: Button
    private lateinit var thermometerButton: Button
    private lateinit var logsButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        circlesButton = findViewById(R.id.circlesButton)
        primesButton = findViewById(R.id.primesButton)
        thermometerButton = findViewById(R.id.thermometerButton)
        logsButton = findViewById(R.id.logsButton)

        val arithmeticButton = findViewById<Button>(R.id.arithmeticButton)

        circlesButton.setOnClickListener {
            val intent = Intent(this, CirclesModuleActivity::class.java)
            startActivity(intent)
        }
        primesButton.setOnClickListener {
            val intent = Intent(this, PrimesModuleActivity::class.java)
            startActivity(intent)
        }

        thermometerButton.setOnClickListener {
            val intent = Intent(this, ThermometerModuleActivity::class.java)
            startActivity(intent)
        }

        logsButton.setOnClickListener {
            val intent = Intent(this, SpeechModule::class.java)
            startActivity(intent)
        }

        arithmeticButton.setOnClickListener {
            val intent = Intent(this, ArithmeticModuleActivity::class.java)
            startActivity(intent)
        }
    }
}