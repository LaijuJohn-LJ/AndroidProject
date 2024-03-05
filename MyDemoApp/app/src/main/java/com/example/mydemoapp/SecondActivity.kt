package com.example.mydemoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val offerTxt = findViewById<TextView>(R.id.txtView)
        val Newoffr = intent.getStringExtra("USER")
        offerTxt.text = Newoffr
    }
}