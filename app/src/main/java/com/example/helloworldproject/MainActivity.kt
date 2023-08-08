package com.example.helloworldproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.core.widget.doOnTextChanged
import java.net.URL
import java.net.URLConnection
import kotlin.reflect.KType
import kotlin.reflect.typeOf

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val numberInput = findViewById<EditText>(R.id.main_activity_value_from)
        val exchangeRateValue = findViewById<TextView>(R.id.main_activity_rate_exchange)
        val currencyFromSpinner = findViewById<Spinner>(R.id.main_activity_currency_from)
        val currencyToSpinner = findViewById<Spinner>(R.id.main_activity_currency_to)
        val currencies = resources.getStringArray(R.array.currencies)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, currencies)
        currencyFromSpinner.adapter = adapter
        currencyToSpinner.adapter = adapter
        currencyFromSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                exchangeRateValue.text = "${currencies[position]}/${currencyToSpinner.selectedItem.toString()}"
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // write code to perform some action
            }
        }
//        val selectedCurrencyFrom = currencyFromSpinner.selectedItem.toString()
//        exchangeRateValue.text = selectedCurrencyFrom
//        currencyFromSpinner
////        val listItems = resources.getStringArray((R.array.currencies))
////        spinner.
//        val data = URL("http://data.fixer.io/api/latest?access_key =57583a2451bf0932d6c4c2f48bfcd893&base=USD&symbols=GBP,JPY,EUR")

    }
}