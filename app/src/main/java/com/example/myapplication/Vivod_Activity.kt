package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Vivod_Activity : AppCompatActivity() {
    val Nums : MutableList<Numbers> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vivod)
        getNums()
        Nums.forEach{
            Log.d("qq", it.toString())
        }


    }
    private fun getNums()
    {
        val preferences = getSharedPreferences("pref", MODE_PRIVATE)
        var json : String = ""
        if (!preferences.contains("json")){
            return
        }
        else
        {
            json = preferences.getString("json", "notJSON").toString()
            val NumsList = Gson().fromJson<List<Numbers>>(json, object: TypeToken<List<Numbers>>(){}.type)
            Nums.addAll((NumsList))
        }
    }
}