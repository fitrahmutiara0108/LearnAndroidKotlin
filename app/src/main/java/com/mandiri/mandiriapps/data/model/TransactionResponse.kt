package com.mandiri.mandiriapps.data.model

import com.google.gson.annotations.SerializedName

data class TransactionResponse (
    @SerializedName("id")
    val id: String?,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("metode_trf")
    val metodeTrf: String?,
    @SerializedName("name")
    val name: String,
    @SerializedName("nominal_saldo")
    val saldo: String?,
    @SerializedName("flag_debit_card")
    val debitCard: Int
)