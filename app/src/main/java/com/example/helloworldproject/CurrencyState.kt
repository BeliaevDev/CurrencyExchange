package com.example.helloworldproject

class CurrencyState(
    private var toCurrency: String,
    private var fromCurrency: String,
    private var fromValue: Double = 0.0,
    private var toValue: Double = 0.0) {


    fun setToCurrency(value: String) { toCurrency = value }
    fun setFromCurrency(value: String) { fromCurrency = value }
    fun setToValue(value: Double) { toValue = value }
    fun setFromValue(value: Double) { fromValue = value }

    fun getToCurrency(): String { return toCurrency }
    fun getFromCurrency(): String { return fromCurrency }
    fun getToValue(): Double { return toValue }
    fun getFromValue(): Double { return fromValue }
}