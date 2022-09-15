package ar.edu.unlam.mvvmconlivedata.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.unlam.mvvmconlivedata.data.model.QuoteModel
import ar.edu.unlam.mvvmconlivedata.data.model.QuoteProvider
import ar.edu.unlam.mvvmconlivedata.ui.domain.GetQoutesUseCases
import ar.edu.unlam.mvvmconlivedata.ui.domain.GetRandomQuotes
import kotlinx.coroutines.launch

class QuoteViewModel : ViewModel(){
    val quoteModel= MutableLiveData<QuoteModel?>()
    val isLoading = MutableLiveData<Boolean>()
    var getQuotesUseCases = GetQoutesUseCases()
    var getRandomQuotesUseCase = GetRandomQuotes()
    fun onCreate() {

        viewModelScope.launch {
            isLoading.postValue(true)
            val result:List<QuoteModel>? = getQuotesUseCases()
            if (!result.isNullOrEmpty()){
                quoteModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }
    fun randomQuote(){
        isLoading.postValue(true)
val quote:QuoteModel? = getRandomQuotesUseCase()
        if (quote!=null){
            quoteModel.postValue(quote)
        }
        isLoading.postValue(false)


        //  val currenQuote:QuoteModel=QuoteProvider.random()
     //   quoteModel.postValue(currenQuote)
    }


}