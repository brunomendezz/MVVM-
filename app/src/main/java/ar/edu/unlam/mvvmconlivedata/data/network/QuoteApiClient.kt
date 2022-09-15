package ar.edu.unlam.mvvmconlivedata.data.network

import ar.edu.unlam.mvvmconlivedata.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {
    @GET("/.json")
    suspend fun getAllQuotes():Response<List<QuoteModel>>
}