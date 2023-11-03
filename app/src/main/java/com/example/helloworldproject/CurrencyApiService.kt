package com.example.helloworldproject

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

//"https://currate.ru/api/?get=rates&pairs=${currencyFromSpinner.selectedItem}${currencyToSpinner.selectedItem}&key="
interface CurrencyApiServic {
    @GET("/api/?get=rates")
    suspend fun getPairs(
        @Query("pairs") pairs: String,
        @Query("key") apiKey: String
    ): CurrencyResponse
}

interface CurrencyApiService {
// @Headers({"api-key: 2VPsmOUVeZpS5ESNLoPbCRHNP6WN3309", "Ddd: ddd"})
    @Headers("apikey: 2VPsmOUVeZpS5ESNLoPbCRHNP6WN3309")
    @GET("live")
    suspend fun getExchangeRate(
        @Query("source") source: String,
        @Query("currencies") currencies: String
    ): CurrencyResponse
}
