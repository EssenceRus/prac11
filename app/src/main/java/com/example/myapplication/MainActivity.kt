package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

private lateinit var Btn : Button
private lateinit var Btn2 : Button
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Btn = findViewById(R.id.button)
        Btn2 = findViewById(R.id.button2)
        Btn.setOnClickListener{
            val intent = Intent(this, Vvod_Activity::class.java)
            startActivity((intent))
        }
        Btn2.setOnClickListener{
            val intent = Intent(this, Vivod_Activity::class.java)
            startActivity((intent))
        }

    }
}