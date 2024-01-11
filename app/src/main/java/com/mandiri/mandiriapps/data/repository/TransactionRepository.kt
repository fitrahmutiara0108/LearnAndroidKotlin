package com.mandiri.mandiriapps.data.repository

import com.mandiri.mandiriapps.data.model.TransactionResponse
import retrofit2.Response

interface TransactionRepository {
    suspend fun getTransaction(): Response<List<TransactionResponse>>
}