package com.mandiri.mandiriapps.data.repository

import com.mandiri.mandiriapps.data.model.TransactionResponse
import com.mandiri.mandiriapps.data.remote.TransactionRemoteDataSource
import retrofit2.Response
import javax.inject.Inject

class TransactionRepositoryImpl @Inject constructor(
    private val remoteDataSource: TransactionRemoteDataSource
): TransactionRepository {

    override suspend fun getTransaction(): Response<List<TransactionResponse>>{
        return remoteDataSource.getTransaction()
    }
}