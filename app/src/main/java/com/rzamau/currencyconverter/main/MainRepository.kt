package com.rzamau.currencyconverter.main

import com.rzamau.currencyconverter.data.models.CurrencyResponse
import com.rzamau.currencyconverter.util.Resource

interface MainRepository {
    suspend fun getRates(base: String): Resource<CurrencyResponse>
}