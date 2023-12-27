package com.notepad.data.repository

import androidx.lifecycle.LiveData
import com.notepad.data.db.QuoteDao
import com.notepad.data.model.Quote

class QuoteRepositoryImpl (private val quoteDao: QuoteDao) : QuoteRepository{
    override fun addQuote(quote: Quote) {
        quoteDao.addQuote(quote)
    }

    override fun getQuotes(): LiveData<List<Quote>> = quoteDao.getQuotes()

}