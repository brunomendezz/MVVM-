package ar.edu.unlam.mvvmconlivedata.ui.domain

import ar.edu.unlam.mvvmconlivedata.data.QuoteRepository
import ar.edu.unlam.mvvmconlivedata.data.model.QuoteModel

class GetQoutesUseCases {

    private val repository = QuoteRepository()

    suspend operator fun invoke():List<QuoteModel>? = repository.getAllQuotes()

}