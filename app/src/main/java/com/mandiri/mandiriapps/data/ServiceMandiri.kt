package com.mandiri.mandiriapps.data

import com.mandiri.mandiriapps.data.model.TransactionResponse
import retrofit2.Response
import retrofit2.http.GET

interface ServiceMandiri {

    @GET("transaction")
    suspend fun getTransaction(): Response<List<TransactionResponse>>
}