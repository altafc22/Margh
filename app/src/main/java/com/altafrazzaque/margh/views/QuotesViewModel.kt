package com.altafrazzaque.margh.views

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.altafrazzaque.margh.repository.QuotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuotesViewModel @Inject constructor(
    private val quoteRepository: QuotesRepository
) : ViewModel() {

    fun getQuotes() = quoteRepository.expenses

    fun refreshQuotes() = viewModelScope.launch(Dispatchers.IO) {
        quoteRepository.refreshQuotes()
    }
}