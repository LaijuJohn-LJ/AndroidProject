package com.example.mathgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var addition:Button
    lateinit var substraction:Button
    lateinit var multiplication:Button
    lateinit var division:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addition = findViewById(R.id.buttonAdd)
        substraction = findViewById(R.id.buttonSub)
        multiplication = findViewById(R.id.buttonMul)
        division = findViewById(R.id.buttonDiv)

        addition.setOnClickListener(){
            val intent = Intent(this@MainActivity,GameActivity::class.java)
            intent.putExtra("buttonClickedAdd", "addition")
            intent.putExtra("title", "Addition Game")

            startActivity(intent)
        }

        substraction.setOnClickListener(){
            val intent = Intent(this@MainActivity,GameActivity::class.java)
            intent.putExtra("buttonClickedsub", "sub")
            intent.putExtra("title", "Subtraction Game")

            startActivity(intent)
        }
        multiplication.setOnClickListener(){
            val intent = Intent(this@MainActivity,GameActivity::class.java)
            intent.putExtra("buttonClickedmul", "mul")
            intent.putExtra("title", "Multiplication Game")

            startActivity(intent)
        }

        division.setOnClickListener(){
            val intent = Intent(this@MainActivity,GameActivity::class.java)
            intent.putExtra("buttonClickeddiv", "div")
            intent.putExtra("title", "Division Game")

            startActivity(intent)
        }

    }
}