package com.mandiri.mandiriapps.usecase

import com.mandiri.mandiriapps.data.model.TransactionResponse
import com.mandiri.mandiriapps.data.repository.TransactionRepository
import retrofit2.Response
import javax.inject.Inject

class TransactionUseCase @Inject constructor(
    private val repository: TransactionRepository
) {
    suspend fun getTransaction() : Response<List<TransactionResponse>> {
        return repository.getTransaction()
    }
}