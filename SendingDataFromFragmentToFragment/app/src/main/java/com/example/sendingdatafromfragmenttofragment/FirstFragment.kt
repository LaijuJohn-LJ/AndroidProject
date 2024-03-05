package com.example.sendingdatafromfragmenttofragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction


class FirstFragment : Fragment() {




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater.inflate(R.layout.fragment_first, container, false)
        val name:EditText = view.findViewById(R.id.editTextName)
        val send:Button = view.findViewById(R.id.buttonSend)

        send.setOnClickListener(){
            val userName = name.text.toString()
            val bundle = Bundle()
            bundle.putString("username",userName)
            val secondFragment = SecondFragment()
            secondFragment.arguments = bundle

            val fragmentManager:FragmentManager = requireActivity().supportFragmentManager
            val fragmentTransaction:FragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.frame,secondFragment)
            fragmentTransaction.commit()


        }
        // Inflate the layout for this fragment
        return view
    }




}