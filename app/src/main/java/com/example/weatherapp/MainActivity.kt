package com.example.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.GridLayout
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

var Main : String? = null

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        }
fun getData(){

    val text1 = findViewById<TextView>(R.id.t1)
    val edit  = findViewById<EditText>(R.id.search)
    val textView = findViewById<TextView>(R.id.textView)
    val textView1 = findViewById<TextView>(R.id.textView1)
    val textView2 = findViewById<TextView>(R.id.textView2)
    val textView3 = findViewById<TextView>(R.id.textView3)
    val textView4 = findViewById<TextView>(R.id.textView4)
    val textView5 = findViewById<TextView>(R.id.textView5)
    val textView6 = findViewById<TextView>(R.id.description)
    val city = edit.text.toString()
    val url = "https://api.openweathermap.org/data/2.5/weather?q=$city&units=metric&appid=a187135e86e302d2b20dc581b216d65b"
    val queue  = Volley.newRequestQueue(this)
    val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            Response.Listener{response ->
                val arr = response.getJSONArray("weather")
                val x = arr.getJSONObject(0)
                Main = x.getString("main")
                val obj = response.getJSONObject("main")
                val obj1 = response.getJSONObject("wind")
                val obj2 = response.getJSONObject("clouds")
                val Temp = obj.getInt("temp")
                val humidity = obj.getInt("humidity")
                val maxtemp = obj.getInt("temp_max")
                val mintemp = obj.getInt("temp_min")
                val windspeed = obj1.getInt("speed")
                val pressure = obj.getInt("pressure")
                val cloudiness = obj2.getInt("all")
                text1.text = " $Temp°C"
                textView.text = "$mintemp°C"
                textView1.text = "$maxtemp°C"
                textView2.text = "$humidity%"
                textView3.text = "$windspeed m/s"
                textView4.text = "$pressure hPa"
                textView5.text = "$cloudiness%"
                textView6.text= "$Main"
            },
            Response.ErrorListener { error ->
                Toast.makeText(this,"City not found",Toast.LENGTH_SHORT).show()
            })
    queue.add(jsonObjectRequest)

}
    fun button(view: View){

        getData()
        val b = findViewById<TextView>(R.id.feels)
        b.setVisibility(View.VISIBLE)
        val c1 = findViewById<CardView>(R.id.c1)
        val c2 = findViewById<CardView>(R.id.c2)
        val c3 = findViewById<CardView>(R.id.c3)
        c1.setVisibility(View.VISIBLE)
        c2.setVisibility(View.VISIBLE)
        c3.setVisibility(View.VISIBLE)
        val c4 = findViewById<CardView>(R.id.c4)
        c4.setVisibility(View.VISIBLE)
        val c5 = findViewById<CardView>(R.id.c5)
        c5.setVisibility(View.VISIBLE)
        val c6 = findViewById<CardView>(R.id.c6)
        c6.setVisibility(View.VISIBLE)
    }
}





