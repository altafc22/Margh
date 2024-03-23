package com.altafrazzaque.margh.network

import com.altafrazzaque.margh.model.QuoteItem
import retrofit2.http.GET

interface QuotesService {
    @GET("ENDPOINT_TO_GET_RESULT_FROM_API")
    suspend fun getQuotes(): List<QuoteItem>
}
