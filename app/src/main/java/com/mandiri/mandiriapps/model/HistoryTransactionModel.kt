package com.mandiri.mandiriapps.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Parcelize
data class HistoryTransactionModel(
    val date: String,
    val titleTransaction: String,
    val subtitleTransaction: String,
    val balanceTransaction: String,
    val iconTransaction: Int,
    val statusTransaction: Int
): Parcelable

enum class StatusTransaction(val value: Int){
    Berhasil(1),
    Gagal(2),
    Pending(3)
}

enum class StatusTransfer(val value: String){
    Credit("Credit"),
    Debit("Debit")
}