package ar.edu.unlam.mvvmconlivedata.data

import ar.edu.unlam.mvvmconlivedata.data.model.QuoteModel
import ar.edu.unlam.mvvmconlivedata.data.model.QuoteProvider
import ar.edu.unlam.mvvmconlivedata.data.network.QuoteService

class QuoteRepository {
    private val api  = QuoteService()

    suspend fun getAllQuotes():List<QuoteModel>{
        val response:List<QuoteModel> = api.getQuotes()
        QuoteProvider.quotes=response
        return response
    }
}