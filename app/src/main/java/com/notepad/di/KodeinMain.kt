package com.notepad.di

import org.kodein.di.DI

val kodeinApp = DI{
    import(databaseModule)
    import(repositoryModule)
}