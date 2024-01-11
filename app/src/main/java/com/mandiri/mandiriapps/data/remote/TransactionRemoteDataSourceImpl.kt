package com.mandiri.mandiriapps.data.remote

import com.mandiri.mandiriapps.data.ServiceMandiri
import com.mandiri.mandiriapps.data.model.TransactionResponse
import retrofit2.Response
import javax.inject.Inject

class TransactionRemoteDataSourceImpl @Inject constructor(
    private val service: ServiceMandiri
) : TransactionRemoteDataSource {
    override suspend fun getTransaction(): Response<List<TransactionResponse>> {
        return service.getTransaction()
    }

}