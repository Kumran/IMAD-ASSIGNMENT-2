package com.example.imadassignment2

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ScoreScreen : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score_screen)

// declare the array again
        val questions = arrayOf(
            "In 1990, Nelson Mandela was released from prison.",
            "In 1903, the first woman won the Nobel Prize.",
            "The Mona Lisa was painted by Leonardo Da Vinci.",
            "The first person to walk on the moon was Ronaldo",
            "The first car was made in 300BC"
        )
//declare the array for boolean answers
        val answers = booleanArrayOf(true, true, true, false, false)
//declaration for score
        val score = intent.getIntExtra("score", 0)
//declarations for textviews and buttons
        val scoreTextView = findViewById<TextView>(R.id.textViewScore)
        val feedbackTextView = findViewById<TextView>(R.id.textViewFeedback)
        val reviewTextView = findViewById<TextView>(R.id.textViewReview)
        val reviewButton = findViewById<Button>(R.id.reviewButton)
        val exitButton = findViewById<Button>(R.id.exitButton)
//links the textview to the code for the score
        scoreTextView.text = "Your score: $score / 5"
//links the code for feedback to the feedback textview, it'll display certain statements depending on your score
        feedbackTextView.text = when (score) {
            in 3..5 -> "Great job!"
            in 1..2 -> "Keep practicing!"
            else -> "Ahh mahn"
        }
//button when pressed shows the questions and answers
        reviewButton.setOnClickListener {
            val builder = StringBuilder()
            for (i in questions.indices) {
                builder.append("Q${i + 1}: ${questions[i]}\n")
                builder.append("Correct Answer: ${answers[i]}\n\n")
            }
//links the code to the textview using the .text and .toString()
            reviewTextView.text = builder.toString()
        }
//button used to exit the application
        exitButton.setOnClickListener {
            finishAffinity()
        }
    }
}