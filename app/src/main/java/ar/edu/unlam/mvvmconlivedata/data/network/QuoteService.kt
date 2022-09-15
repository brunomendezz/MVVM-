package ar.edu.unlam.mvvmconlivedata.data.network

import ar.edu.unlam.mvvmconlivedata.core.RetrofitHelper
import ar.edu.unlam.mvvmconlivedata.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class QuoteService {

    val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getQuotes():List<QuoteModel>{

        return withContext(Dispatchers.IO){
            val response:Response<List<QuoteModel>> = retrofit.create(QuoteApiClient::class.java).getAllQuotes()
             response.body()?: emptyList()
        }

    }
}