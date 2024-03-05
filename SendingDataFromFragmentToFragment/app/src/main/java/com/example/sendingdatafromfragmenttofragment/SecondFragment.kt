package com.example.sendingdatafromfragmenttofragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView


class SecondFragment : Fragment() {




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater.inflate(R.layout.fragment_second, container, false)

        val name:TextView = view.findViewById(R.id.textViewName)
        name.text =  arguments?.getString("username").toString()


        return view
    }



}