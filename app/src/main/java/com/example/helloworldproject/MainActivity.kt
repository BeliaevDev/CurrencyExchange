package com.example.helloworldproject

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.helloworldproject.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var state: CurrencyState
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val currencies = resources.getStringArray(R.array.currencies)
        val adapter = CurrencyAdapter(this, currencies)
        binding.currencyFromSpinner.adapter = adapter
        binding.currencyToSpinner.adapter = adapter
        binding.currencyFromSpinner.setSelection(currencies.indices.random())
        binding.currencyToSpinner.setSelection(currencies.indices.random())

        state = CurrencyState(binding.currencyToSpinner.selectedItem.toString(), binding.currencyToSpinner.selectedItem.toString())

//        binding.valueFromEditText.onFocusChangeListener =
//            View.OnFocusChangeListener { _, hasFocus ->
//                if (!hasFocus) {
//                    convert()
//                }
//            }
//
//        binding.converterLayout.setOnClickListener {
//            binding.valueFromEditText.clearFocus()
//        }
        binding.currencyFromSpinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                if (selectedItemView != null) {
                    state.setFromCurrency(selectedItemView.findViewById<TextView>(R.id.currencyName).text.toString())
                }
                convert()
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // your code here
            }
        }
        binding.currencyToSpinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                if (selectedItemView != null) {
                    state.setToCurrency(selectedItemView.findViewById<TextView>(R.id.currencyName).text.toString())
                }
                convert()
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // your code here
            }
        }
        binding.valueToEditText

//        binding.changeBtn.setOnClickListener {
//            val fromPos = adapter.getPosition(binding.currencyFromSpinner.selectedItem.toString())
//            val toPos = adapter.getPosition(binding.currencyToSpinner.selectedItem.toString())
//            val valueFrom = binding.valueFromEditText.text
//            val valueTo = binding.valueToEditText.text
//            binding.currencyFromSpinner.setSelection(toPos)
//            binding.currencyToSpinner.setSelection(fromPos)
//            binding.valueFromEditText.text = valueTo
//            binding.valueToEditText.text = valueFrom
//        }
//        binding.valueToEditText.setOnClickListener {
//            val clipboard: ClipboardManager =
//                getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
//            val clip = ClipData.newPlainText("value", binding.valueToEditText.text)
//            clipboard.setPrimaryClip(clip)
//            Toast.makeText(applicationContext, "Value copied", Toast.LENGTH_SHORT).show()
//        }
//
//        binding.valueFromEditText.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
//            var consumed = false
//            if (keyCode == KEYCODE_ENTER) {
//                consumed = true
//                binding.valueFromEditText.clearFocus()
//                val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
//                imm.hideSoftInputFromWindow(view.windowToken, 0)
//            }
//            consumed
//        })
    }

    private fun convert() {
        Log.i("state_from", state.getFromCurrency())
        Log.i("state_from", state.getFromValue().toString())
        Log.i("state_to", state.getToCurrency())
        Log.i("state_to", state.getToValue().toString())
//        val fstCurrency = binding.currencyFromSpinner.selectedItem.toString()
//        val sndCurrency = binding.currencyToSpinner.selectedItem.toString()
//        val pair = "${fstCurrency}${sndCurrency}"
//        Log.i("api_currency", fstCurrency)
//        Log.i("api_currency", sndCurrency)
//        Log.i("api_currency", pair)
//        CoroutineScope(Dispatchers.IO).launch {
//            val currencyResponse: CurrencyResponse = currencyApi.getExchangeRate(fstCurrency, sndCurrency)
//            Log.i("api_currency_value", currencyResponse.toString())
//            val currency = currencyResponse.quotes[pair]
//            runOnUiThread {
//                binding.exchangeRateTv.text = getString(R.string.exchange_rate_value, fstCurrency, currency, sndCurrency)
//                val value = currency?.times(binding.valueFromEditText.text.toString().toFloat())
//                binding.valueToEditText.setText(value.toString())
//            }
//            Log.i("api_currency", currency.toString())
//        }
    }
}

