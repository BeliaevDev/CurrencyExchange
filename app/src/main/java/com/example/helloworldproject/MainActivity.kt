package com.example.helloworldproject

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.URL


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val valueFromText = findViewById<EditText>(R.id.main_activity_value_from)
        val convertBtn = findViewById<Button>(R.id.main_activity_convert_btn)
        val exchangeRateValue = findViewById<TextView>(R.id.main_activity_rate_exchange)
        val currencyFromSpinner = findViewById<Spinner>(R.id.main_activity_currency_from)
        val currencyToSpinner = findViewById<Spinner>(R.id.main_activity_currency_to)
        val currencies = resources.getStringArray(R.array.currencies)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, currencies)
        currencyFromSpinner.adapter = adapter
        currencyToSpinner.adapter = adapter
        convertBtn.setOnClickListener {
            val url = "https://currate.ru/api/?get=rates&pairs=${currencyFromSpinner.selectedItem}${currencyToSpinner.selectedItem}&key=cf4794f9809d6220e0bed03cf19705ea"
            val json = try { URL(url).readText() } catch (e: Exception) { Log.e("Network", "error") }
//            exchangeRateValue.text = json
            Log.i("JSON", json.toString())
        }

//        val data = URL("http://data.fixer.io/api/latest?access_key =57583a2451bf0932d6c4c2f48bfcd893&base=USD&symbols=GBP,JPY,EUR")
    }
}