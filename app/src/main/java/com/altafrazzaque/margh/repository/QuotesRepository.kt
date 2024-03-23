package com.altafrazzaque.margh.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.altafrazzaque.margh.database.AppDatabase
import com.altafrazzaque.margh.network.QuotesService

import com.altafrazzaque.margh.model.QuoteItem
import com.altafrazzaque.margh.model.TEST_DATA

import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import timber.log.Timber
import javax.inject.Inject

class QuotesRepository @Inject constructor(
    private val quotesService: QuotesService,
    private val database: AppDatabase
) {

    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    val expenses: LiveData<List<QuoteItem>?> = database.quotesDao.getQuotes().map { it }

    fun refreshQuotes() {
        try {
            val jsonString = TEST_DATA
            val jsonAdapter = moshi.adapter<List<QuoteItem>>(
                Types.newParameterizedType(List::class.java, QuoteItem::class.java)
            )
            val items = jsonAdapter.fromJson(jsonString) ?: throw IllegalStateException("Invalid JSON")
            database.quotesDao.insertAll(items)
        } catch (e: Exception) {
            Timber.w(e)
        }
    }
}