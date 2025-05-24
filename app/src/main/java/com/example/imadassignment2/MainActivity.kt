package com.example.imadassignment2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //The start button
        val startButton = findViewById<Button>(R.id.startButton)

        //set on click listener links the button to the desired function
        startButton.setOnClickListener {
            val intent = Intent(this, QuestionScreen::class.java)//links the two activities
            startActivity(intent)
            finish()
        }
    }
}