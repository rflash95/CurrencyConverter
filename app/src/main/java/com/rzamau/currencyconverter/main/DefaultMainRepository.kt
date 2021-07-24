package com.rzamau.currencyconverter.main

import com.rzamau.currencyconverter.Constants.Companion.API_KEY
import com.rzamau.currencyconverter.data.CurrencyApi
import com.rzamau.currencyconverter.data.models.CurrencyResponse
import com.rzamau.currencyconverter.util.Resource
import javax.inject.Inject

class DefaultMainRepository @Inject constructor(
    private val api: CurrencyApi
) : MainRepository {

    override suspend fun getRates(base: String): Resource<CurrencyResponse> {
        return try {
            val response = api.getRates(API_KEY, base)
            val result = response.body()
            if (response.isSuccessful && result != null) {
                Resource.Success(result)
            } else {
                Resource.Error(response.message())
            }
        } catch (e: Exception) {
            Resource.Error(e.message ?: "An error occured")
        }
    }
}