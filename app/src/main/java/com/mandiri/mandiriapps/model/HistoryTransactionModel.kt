package com.mandiri.mandiriapps.model

data class HistoryTransactionModel(
    val date: String,
    val titleTransaction: String,
    val subtitleTransaction: String,
    val balanceTransaction: String,
    val iconTransaction: Int,
    val statusTransaction: Int
)

enum class StatusTransaction(val value: Int){
    Berhasil(1),
    Gagal(2),
    Pending(3)
}

enum class StatusTransfer(val value: String){
    Credit("Credit"),
    Debit("Debit")
}
