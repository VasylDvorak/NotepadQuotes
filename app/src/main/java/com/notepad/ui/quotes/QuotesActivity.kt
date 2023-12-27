package com.notepad.ui.quotes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.notepad.data.model.Quote
import com.notepad.databinding.ActivityQuotesBinding
import com.notepad.utils.Constants
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.android.closestDI
import org.kodein.di.android.x.viewmodel.viewModel


class QuotesActivity : AppCompatActivity(), DIAware {

    override val di: DI by closestDI()
    private var binding: ActivityQuotesBinding? = null

    private val viewModel: QuotesViewModel by viewModel(tag= Constants.quotesViewModel)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuotesBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        initializeUi()

    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }

    private fun initializeUi() {

        binding?.apply {
            // Observing LiveData from the QuotesViewModel which in turn observes
            // LiveData from the repository, which observes LiveData from the DAO ☺
            viewModel.getQuotes().observe(this@QuotesActivity, Observer { quotes ->
                val stringBuilder = StringBuilder()
                quotes.forEach { quote ->
                    stringBuilder.append("$quote\n\n")
                }
                textViewQuotes.text = stringBuilder.toString()
            })

            // When button is clicked, instantiate a Quote and add it to DB through the ViewModel
            buttonAddQuote.setOnClickListener {
                val quote = Quote(editTextQuote.text.toString(), editTextAuthor.text.toString())
                viewModel.addQuote(quote)
                editTextQuote.setText("")
                editTextAuthor.setText("")
            }
        }
    }


}