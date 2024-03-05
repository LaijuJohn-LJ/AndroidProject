package com.example.intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    lateinit var detailstext:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        detailstext = findViewById(R.id.textViewDetails)
        var userName:String = intent.getStringExtra("username").toString()
       var userAge:Int =  intent.getIntExtra("userage",0)
        detailstext.text = "your name is $userName and age $userAge"
    }
}