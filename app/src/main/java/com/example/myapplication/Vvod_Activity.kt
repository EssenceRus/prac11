package com.example.myapplication

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

private lateinit var nameText: EditText
private lateinit var surenameText: EditText
private lateinit var numberText: EditText
private lateinit var dobav : Button
var nums : MutableList<Numbers> = mutableListOf()
class Vvod_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getNums()
        setContentView(R.layout.activity_vvod)
        val mPrefs = getPreferences(MODE_PRIVATE)
        nameText = findViewById(R.id.NameText)
        surenameText = findViewById((R.id.SurenameText))
        numberText = findViewById(R.id.NumbeerText)
        dobav = findViewById(R.id.button3)




        dobav.setOnClickListener{
            addNums(nameText.text.toString(), surenameText.text.toString(), numberText.text.toString())
        }


    }
    private fun getNums()
    {
        val preferences = getSharedPreferences("pref", MODE_PRIVATE)
        var json : String = ""
        if (!preferences.contains("json"))
        {
            return
        }
        else
        {
            json = preferences.getString("json", "notJSON").toString()
        }
        val numsList = Gson().fromJson<List<Numbers>>(json, object: TypeToken<List<Numbers>>(){}.type)
        nums.addAll(numsList)
    }

    private fun addNums(name:String, surename:String, number:String)
    {
        val Temp = Numbers(name, surename, number)
        nums.add(Temp)
        val preferences = getSharedPreferences("pref", MODE_PRIVATE)
        preferences.edit{
            this.putString("json", Gson().toJson(nums).toString())
        }

    }
}