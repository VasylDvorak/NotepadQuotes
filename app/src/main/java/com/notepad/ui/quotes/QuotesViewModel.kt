package com.notepad.ui.quotes

import androidx.lifecycle.ViewModel
import com.notepad.data.model.Quote
import com.notepad.data.repository.QuoteRepository

class QuotesViewModel (private val quoteRepository: QuoteRepository) : ViewModel() {
    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)
    fun getQuotes() = quoteRepository.getQuotes()
}