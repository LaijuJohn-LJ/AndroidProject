package com.example.mathgame

import android.content.Intent
import android.graphics.Color
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.Locale
import kotlin.random.Random

class GameActivity : AppCompatActivity() {

    lateinit var textScore:TextView
    lateinit var textLife:TextView
    lateinit var textTime:TextView

    lateinit var textQuestion:TextView
    lateinit var editTextAnswer:EditText
    lateinit var buttonOk:Button
    lateinit var buttonNext:Button
//    lateinit var number1: Number
//    lateinit var number2: Number


    var correctAnswer = 0
    var userScore = 0
    var userLife = 3


    lateinit var timer:CountDownTimer
    private val startTimerInMillis:Long = 20000
    var timeleftMillis:Long = startTimerInMillis

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        //user  select category title will change
        val title = intent.getStringExtra("title")
        supportActionBar!!.title = title

        textScore = findViewById(R.id.textViewScore)
        textLife = findViewById(R.id.textViewLife)
        textTime = findViewById(R.id.textViewTime)

        textQuestion = findViewById(R.id.textViewQuestion)
        editTextAnswer = findViewById(R.id.editTextAnswer)
        buttonOk = findViewById(R.id.buttonOk)
        buttonNext = findViewById(R.id.buttonNext)




        gameContinue()

        buttonOk.setOnClickListener(){
            val input = editTextAnswer.text.toString()
            if(input == "")
            {
                Toast.makeText(applicationContext,"Please write an answer or click next button",
                    Toast.LENGTH_LONG).show()
            }
            else {
                pauseTimer()

                val userAnswer = input.toInt()
                if (userAnswer == correctAnswer)
                {
                    userScore = userScore + 10
                    textQuestion.text = "Congrajulations ! your answer is correct"
                    textQuestion.setTextColor(Color.rgb(0,128,0)) // Set text color to green
                    textScore.text = userScore.toString()
                    editTextAnswer.setText("")
                    editTextAnswer.visibility = View.INVISIBLE // Hide editTextAnswer
                    val editText = findViewById<TextView>(R.id.textViewQuestion)
                    editText.setBackgroundColor(Color.TRANSPARENT) // Change to desired color
                }else{
                    userLife--
                    textQuestion.text = "Sorry ! Your answer is wrong"
                    textQuestion.setTextColor(Color.rgb(255,0,0)) // Set text color to green
                    textLife.text = userLife.toString()
                    editTextAnswer.setText("")
                    editTextAnswer.visibility = View.INVISIBLE // Hide editTextAnswer
                    val editText = findViewById<TextView>(R.id.textViewQuestion)
                    editText.setBackgroundColor(Color.TRANSPARENT) // Change to desired color

                }
            }


        }

        buttonNext.setOnClickListener(){
            pauseTimer()
            resetTimer()
            val editText = findViewById<TextView>(R.id.textViewQuestion)
            editText.background = resources.getDrawable(R.drawable.text_shape) // Assuming you have a shape resource file named rounded_background.xml in your drawable folder

            editTextAnswer.setVisibility(View.VISIBLE); // Show editTextAnswer
            editTextAnswer.setText("")
            if (userLife == 0)
                    {
                    Toast.makeText(applicationContext,"GAME OVER",Toast.LENGTH_LONG).show()
                    val intent = Intent(this@GameActivity,ResultActivity::class.java)
                    intent.putExtra("Score",userScore)
                    startActivity(intent)
                    finish()
                    }else
                    {
                        gameContinue()
                    }


        }

    }
    fun gameContinue(){
        val number1 = Random.nextInt(0,100)
        val  number2 = Random.nextInt(0,100)
        val buttonClicked = intent.getStringExtra("buttonClickedAdd")
        val buttonClickedSub = intent.getStringExtra("buttonClickedsub")
        val buttonClickedMul = intent.getStringExtra("buttonClickedmul")

        if (buttonClicked == "addition") {
            setTitle(title)
            textQuestion.text = "$number1 + $number2"
            textQuestion.setTextColor(Color.WHITE)
            correctAnswer = number1 + number2
        } else if (buttonClickedSub == "sub") {
            setTitle(title)
            val adjustedNumber1 = if (number1 < number2) number2 else number1
            val adjustedNumber2 = if (number1 < number2) number1 else number2
            textQuestion.text = "$adjustedNumber1 - $adjustedNumber2"
            textQuestion.setTextColor(Color.WHITE)
            correctAnswer = adjustedNumber1 - adjustedNumber2
        } else if (buttonClickedMul == "mul") {
            setTitle(title)
            textQuestion.text = "$number1 * $number2"
            textQuestion.setTextColor(Color.WHITE)
            correctAnswer = number1 * number2
        } else {
            setTitle(title)
            val adjustedNumber1 = if (number1 < number2) number2 else number1
            val adjustedNumber2 = if (number1 < number2) number1 else number2
            textQuestion.text = "$adjustedNumber1 / $adjustedNumber2"
            textQuestion.setTextColor(Color.WHITE)
            correctAnswer = adjustedNumber1 / adjustedNumber2
        }





        startTimer()

    }
    fun startTimer(){
        timer = object : CountDownTimer(timeleftMillis,1000){
            override fun onTick(millisUntilFinished: Long) {

                timeleftMillis = millisUntilFinished
                updateText()
            }

            override fun onFinish() {
                pauseTimer()
                resetTimer()
                updateText()

                userLife--
                textLife.text = userLife.toString()
                textQuestion.text = "Sorry, Time is up"
                textQuestion.setTextColor(Color.RED)
                val editText = findViewById<TextView>(R.id.textViewQuestion)
                editText.setBackgroundColor(Color.TRANSPARENT) // Change to desired color
                // Play audio
                val mediaPlayer = MediaPlayer.create(applicationContext, R.raw.mys)
                mediaPlayer.start()


            }

        }.start()
    }
    fun updateText()
    {
        val remainingTime: Int = (timeleftMillis/1000).toInt()
        textTime.text = String.format(Locale.getDefault(),"%02d",remainingTime)
    }
    fun pauseTimer()
    {
       timer.cancel()
    }
    fun resetTimer(){
timeleftMillis = startTimerInMillis
        updateText()
    }
}