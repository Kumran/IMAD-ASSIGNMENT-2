// Title: HISTORY QUIZ APP
// Author: Kumran Maistry
// Date: 24 May 2025
// Version: 1,0
// Available: https://www.w3schools.com/kotlin/index.php
// Additional Reference: Youtube, ChatGpt for recommendation of updatequestion() and checkanswer()

package com.example.imadassignment2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class QuestionScreen : AppCompatActivity() {

    //array to store history questions
    val questions = arrayOf(
        "In 1990, Nelson Mandela was released from prison.",
        "In 1903, the first woman won the Nobel Prize.",
        "The Mona Lisa was painted by Leonardo Da Vinci.",
        "The first person to walk on the moon was Ronaldo",
        "The first car was made in 300BC"
    )

    //array to store true/false answers which are boolean
    val answers = booleanArrayOf(true, true, true, false, false)

    //variable declaration which also initializes it to 0
    var score = 0
    var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_question_screen)

        //variable declarations for textviews and buttons which will be used in the app
        val questionText = findViewById<TextView>(R.id.textViewDisplayQuestion)
        val feedbackText = findViewById<TextView>(R.id.textViewInstantFeedback)
        val trueBtn = findViewById<Button>(R.id.trueButton)
        val falseBtn = findViewById<Button>(R.id.falseButton)
        val nextBtn = findViewById<Button>(R.id.nextButton)

        //updateQuestion() updates the UI to show the current question and  resets the feedback and buttons for the next interaction
        fun updateQuestion() {
            questionText.text = questions[currentIndex]//sets text of UI element
            feedbackText.text = ""//clears  feedback texts
            trueBtn.isEnabled = true//enables the button
            falseBtn.isEnabled = true//enables the button
        }

        //updates UI
        updateQuestion()

        //when button is pressed, the app will determine whether answer is correct
        trueBtn.setOnClickListener {
            checkAnswer(true)
        }

        falseBtn.setOnClickListener {
            checkAnswer(false)
        }

        //the next button
        nextBtn.setOnClickListener {
            currentIndex++
        //if else statement for when the user chooses the correct answer, if answer is correct then when next is pushed next questions will appear
            if (currentIndex < questions.size) {
                updateQuestion()
            } else {
        //intent links the two screens with a push of a button
                val intent = Intent(this, ScoreScreen::class.java)
                intent.putExtra("score", score)
                startActivity(intent)
                finish()
            }
        }
    }
//the check answer function compares the user answer to the correct answer, if right the users score will increase
    fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = answers[currentIndex]
        if (userAnswer == correctAnswer) {
            score++
        }
//feedback textview declaration
        val feedbackText = findViewById<TextView>(R.id.textViewInstantFeedback)
//if else that determines whether the feedback textview should output correct or incorrect
        if (userAnswer == correctAnswer) {
            feedbackText.text = "Correct!"
        } else {
            feedbackText.text = "Incorrect!"
        }

        // Disables button after being pressed
        findViewById<Button>(R.id.trueButton).isEnabled = false
        findViewById<Button>(R.id.falseButton).isEnabled = false
    }
}