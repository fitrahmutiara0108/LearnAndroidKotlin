package com.mandiri.mandiriapps.presentation.message.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mandiri.mandiriapps.R
import com.mandiri.mandiriapps.data.model.TransactionResponse
import com.mandiri.mandiriapps.model.HistoryTransactionModel
import com.mandiri.mandiriapps.model.NotificationModel
import com.mandiri.mandiriapps.usecase.TransactionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryTransactionViewModel @Inject constructor(
    private val transactionUseCase: TransactionUseCase
) : ViewModel() {
    private lateinit var _loading: MutableLiveData<Boolean>
    private val _transactionHistory = MutableLiveData<List<TransactionResponse>>()

//    val _loading =
    fun getTransaction() = viewModelScope.launch {
        _loading.postValue(true)
        transactionUseCase.getTransaction().let {
            if (it.isSuccessful) {

            } else {

            }
            _loading.postValue(false)
        }
    }

}