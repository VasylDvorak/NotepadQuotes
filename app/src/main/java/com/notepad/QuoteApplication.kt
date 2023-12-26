package com.notepad

import android.app.Application
import com.notepad.data.db.Database
import com.notepad.data.db.DatabaseFakeImpl
import com.notepad.data.db.QuoteDao
import com.notepad.data.db.QuoteDaoFakeImpl
import com.notepad.data.repository.QuoteRepository
import com.notepad.data.repository.QuoteRepositoryImpl
import com.notepad.ui.quotes.QuotesViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class QuoteApplication :  Application(), KodeinAware {
    override val kodein: Kodein = Kodein.lazy {
        bind<Database>() with singleton { DatabaseFakeImpl() }
        bind<QuoteDao>() with singleton { instance<Database>().quoteDao }
        bind<QuoteRepository>() with singleton { QuoteRepositoryImpl(instance()) }
        bind() from provider { QuotesViewModelFactory(instance()) }

    }
}