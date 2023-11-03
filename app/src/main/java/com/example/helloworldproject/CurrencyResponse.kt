package com.example.helloworldproject

data class CurrencyResponse(
    val success: Boolean,
    val quotes: Map<String, Float>,
    val source: String,
    val timestamp: Int,
)
