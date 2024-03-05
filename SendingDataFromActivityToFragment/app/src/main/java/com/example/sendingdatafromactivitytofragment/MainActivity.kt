package com.example.sendingdatafromactivitytofragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    lateinit var etWeight:EditText
    lateinit var etHeight:EditText
    lateinit var calculate:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etHeight = findViewById(R.id.editTextHeight)
        etWeight = findViewById(R.id.editTextWeight)
        calculate = findViewById(R.id.buttonCalculate)

        val fm:FragmentManager = supportFragmentManager
        val ft:FragmentTransaction =  fm.beginTransaction()
        val bmiFragment = BMIFragment()

        calculate.setOnClickListener(){

            val weight = etWeight.text.toString().toInt()
            val height = etHeight.text.toString().toInt()

            val bundle = Bundle()
            bundle.putInt("weight",weight)
            bundle.putInt("height",height)

            bmiFragment.arguments = bundle

            ft.add(R.id.frame,bmiFragment)
            ft.commit()


        }
    }
}