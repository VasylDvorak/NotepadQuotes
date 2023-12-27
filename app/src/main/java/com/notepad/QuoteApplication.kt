package com.notepad

import android.app.Application
import com.notepad.di.kodeinApp
import org.kodein.di.DIAware


class QuoteApplication :  Application(), DIAware {

    override val di by lazy { kodeinApp }
}

