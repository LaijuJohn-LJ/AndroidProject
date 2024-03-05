package com.example.userinteractions

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet.Constraint
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    lateinit var btn1:Button
    lateinit var btn2:Button
    lateinit var  mylayout:ConstraintLayout
    lateinit var dialogbox:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        mylayout = findViewById(R.id.mylayout)
        dialogbox = findViewById(R.id.dialgbox)

        btn1.setOnClickListener(){
            Toast.makeText(applicationContext,"hi laiju",Toast.LENGTH_LONG)
        }
        btn2.setOnClickListener(){
            Snackbar.make(mylayout,"Snack bar message",Snackbar.LENGTH_INDEFINITE).setAction("closed",
                View.OnClickListener {

                }).show()
        }
        dialogbox.setOnClickListener(){
       ShowAlertDailog()

        }
    }
    fun ShowAlertDailog(){
        var alertdialog = AlertDialog.Builder(this@MainActivity)
        alertdialog.setTitle("Change").setMessage("Do you change the text ?")
            .setIcon(R.drawable.baseline_add_alert_24).setCancelable(false).setNegativeButton("No",
                DialogInterface.OnClickListener{
                    dialog, which: Int ->

                    dialog.cancel()
                }).setPositiveButton("Yes", DialogInterface.OnClickListener{
                    dialog, which ->
                    dialogbox.text = "Alert Dialog"
            })
        alertdialog.create().show()
    }
}