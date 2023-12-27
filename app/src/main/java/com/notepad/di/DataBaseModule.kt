package com.notepad.di

import com.notepad.QuoteApplication
import com.notepad.data.db.Database
import com.notepad.data.db.DatabaseFakeImpl
import com.notepad.data.db.QuoteDao
import org.kodein.di.DI
import org.kodein.di.bindMultiton
import org.kodein.di.bindSingleton
import org.kodein.di.instance

val databaseModule= DI.Module(name = "database"){
    bindSingleton <Database>() {  DatabaseFakeImpl()   }
    bindSingleton<QuoteDao>() { instance<Database>().quoteDao }
    bindMultiton{ app: QuoteApplication -> app.applicationContext }
}