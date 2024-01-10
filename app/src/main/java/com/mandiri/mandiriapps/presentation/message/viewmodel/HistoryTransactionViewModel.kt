package com.mandiri.mandiriapps.presentation.message.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mandiri.mandiriapps.R
import com.mandiri.mandiriapps.model.HistoryTransactionModel
import com.mandiri.mandiriapps.model.NotificationModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

//fungsi view model untuk single responsibility

//kegunaan view model biasanya ketika hp di rotate datanya ga ilang, tetep aman
//kalo ga pake itu ada kemungkinan ketika dirotate data hilang
//live data digunakan agar UI mendapat data terbaru


@HiltViewModel
class HistoryTransactionViewModel @Inject constructor() : ViewModel() {

    private val _historyTransactionData = MutableLiveData<List<HistoryTransactionModel>>()
    val historyTransactionData: LiveData<List<HistoryTransactionModel>> = _historyTransactionData

    fun setData() {
        _historyTransactionData.postValue(populateDataHistoryTransaction())
    }

    private fun populateDataHistoryTransaction(): List<HistoryTransactionModel> {
        return listOf(
            HistoryTransactionModel(
                date = "11 Januari 2024",
                titleTransaction = "debit",
                subtitleTransaction = "Transfer Mandiri - Tiara",
                balanceTransaction = "Rp200.000,00",
                iconTransaction = R.drawable.baseline_account_balance_wallet_24,
                statusTransaction = 1
            ),
            HistoryTransactionModel(
                date = "12 Januari 2024",
                titleTransaction = "credit",
                subtitleTransaction = "Transfer Mandiri - Rens",
                balanceTransaction = "Rp300.000,00",
                iconTransaction = R.drawable.baseline_credit_score_24,
                statusTransaction = 2
            )
        )
    }
}