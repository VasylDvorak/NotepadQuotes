package com.notepad.data.db

import androidx.lifecycle.LiveData
import com.notepad.data.model.Quote

interface QuoteDao {
    fun addQuote(quote: Quote)
    fun getQuotes():LiveData<List<Quote>>
}