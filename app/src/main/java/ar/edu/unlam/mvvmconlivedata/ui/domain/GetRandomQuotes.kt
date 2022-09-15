package ar.edu.unlam.mvvmconlivedata.ui.domain

import ar.edu.unlam.mvvmconlivedata.data.QuoteRepository
import ar.edu.unlam.mvvmconlivedata.data.model.QuoteModel
import ar.edu.unlam.mvvmconlivedata.data.model.QuoteProvider

class GetRandomQuotes {
    private val repository = QuoteRepository()

     operator fun invoke():QuoteModel?{
        val quotes = QuoteProvider.quotes
         if (!quotes.isNullOrEmpty()){
             val randomNumber = (quotes.indices-1).random()
             return quotes[randomNumber]
         }
         return null
     }
}