package com.notepad.data.repository

import androidx.lifecycle.LiveData
import com.notepad.data.model.Quote

interface QuoteRepository {
    fun addQuote(quote: Quote)
    fun getQuotes(): LiveData<List<Quote>>
}