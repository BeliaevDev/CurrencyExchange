package com.example.helloworldproject

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

//private const val BASE_URL = "https://currate.ru/api/"
private val client = OkHttpClient().newBuilder()
    .connectTimeout(40, TimeUnit.SECONDS)
    .readTimeout(40, TimeUnit.SECONDS)
    .build()

private const val BASE_URL = "https://api.apilayer.com/currency_data/"
private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .client(client)
    .build()
val currencyApi: CurrencyApiService = retrofit.create(CurrencyApiService::class.java)