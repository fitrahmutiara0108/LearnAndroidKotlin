package com.mandiri.mandiriapps.module

import com.mandiri.mandiriapps.data.ServiceMandiri
import com.mandiri.mandiriapps.data.remote.TransactionRemoteDataSource
import com.mandiri.mandiriapps.data.remote.TransactionRemoteDataSourceImpl
import com.mandiri.mandiriapps.data.repository.TransactionRepository
import com.mandiri.mandiriapps.data.repository.TransactionRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent:: class)
object MessageModule {

    @Singleton
    @Provides
    fun provideTransactionRemoteDataSource(service: ServiceMandiri): TransactionRemoteDataSource =
        TransactionRemoteDataSourceImpl(service)

    @Provides
    @Singleton
    fun providesTransactionRepository(remoteDataSource: TransactionRemoteDataSource): TransactionRepository =
        TransactionRepositoryImpl(remoteDataSource)
}