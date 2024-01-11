package com.mandiri.mandiriapps.data.remote

import com.mandiri.mandiriapps.data.model.TransactionResponse
import retrofit2.Response

interface TransactionRemoteDataSource {
    suspend fun getTransaction(): Response<List<TransactionResponse>>
}