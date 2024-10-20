package com.example.labo1b

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet

class MainActivity : AppCompatActivity() {
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val constraintLayout = findViewById<ConstraintLayout>(R.id.rootLayout)
        val editText = EditText(this)
        editText.id = View.generateViewId()
        editText.hint="Tapez votre texte ici"
        editText.layoutParams = ConstraintLayout.LayoutParams(0, ConstraintLayout.LayoutParams.WRAP_CONTENT)
        constraintLayout.addView(editText)
        val constraintSet = ConstraintSet()
        constraintSet.clone(constraintLayout)
        constraintSet.connect(editText.id,ConstraintSet.TOP, R.id.textView_img, ConstraintSet.BOTTOM,20)
        constraintSet.connect(editText.id,ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT,20)
        constraintSet.applyTo(constraintLayout)

        val btnAficher = findViewById<Button>(R.id.button)
        btnAficher.setOnClickListener {
            val context = applicationContext
            val text = editText.text
            val duree = Toast.LENGTH_LONG
            val toast = Toast.makeText(context, text, duree)
            toast.show()
        }
        btnAficher.setOnClickListener{
            val alertDialog = AlertDialog.Builder(this)
            alertDialog.setTitle(" Texte saisi ");
            alertDialog.setMessage(editText.text);
            alertDialog.setIcon(android.R.mipmap.sym_def_app_icon);
            alertDialog.setPositiveButton("OK") { _, _ ->
                val toast = Toast . makeText (this, "vous avez choisi OK",
                    Toast.LENGTH_LONG);
                toast.show();
            }
            alertDialog.setNegativeButton("Annuler") { _, _ ->
                val toast = Toast . makeText (this, "vous avez choisi Annuler",
                    Toast.LENGTH_LONG);
                toast.show();
            }
            alertDialog.show()
        }
    }




}