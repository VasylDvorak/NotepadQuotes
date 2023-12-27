package com.notepad.di

import com.notepad.data.repository.QuoteRepository
import com.notepad.data.repository.QuoteRepositoryImpl
import com.notepad.ui.quotes.QuotesViewModel
import com.notepad.utils.Constants
import org.kodein.di.DI
import org.kodein.di.bindProvider
import org.kodein.di.bindSingleton
import org.kodein.di.instance

val repositoryModule= DI.Module(name = "repository"){
    bindSingleton<QuoteRepository>() { QuoteRepositoryImpl(instance()) }
    bindProvider(tag = Constants.quotesViewModel) { QuotesViewModel(instance()) }
}