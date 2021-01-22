package com.example.java_and_kotlin_g11

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.lang.Math.random
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myperson = person( "Kotlin" , 23)
        val textview = findViewById<TextView>(R.id.textview)

        textview.text = greet(myperson.getName())


        val value = generatenumber()
        val numberView = findViewById<TextView>(R.id.numberview)
        numberView.text = (value.toString())


    }
    fun updatenumber (view: View){
        val value = generatenumber()
        val numberView = findViewById<TextView>(R.id.numberview)
        numberView.text = (value.toString())
    }
}


fun generatenumber(): Int{
    val rand = Random()
    val value: Int = rand.nextInt(50)
    return value
}


fun greet(text: String = ""): String{
   return "hi ${text}"
}