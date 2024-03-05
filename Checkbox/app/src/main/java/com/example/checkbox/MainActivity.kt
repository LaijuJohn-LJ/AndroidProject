package com.example.checkbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var male: CheckBox
    lateinit var female: CheckBox
    lateinit var result: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        male = findViewById(R.id.checkBox1)
        female = findViewById(R.id.checkBox2)

        result = findViewById(R.id.textView)

        male.setOnClickListener() {
            if (male.isChecked) {
                result.text = "you are male"

                female.isChecked = false
            } else {
                result.text = "what is your gender"

            }
            female.setOnClickListener() {
                if (female.isChecked) {
                    result.text = "you are female"

                    male.isChecked = false
                } else {
                    result.text = "what is your gender"

                }
            }
//          result.setText("male")
//           male.isChecked = true
//           female.isChecked = false
//       }
//      female.setOnClickListener(){
//           result.setText("female")
//            male.isChecked = false
//           female.isChecked = true
       }
        }
    }