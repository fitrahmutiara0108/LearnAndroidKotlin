package com.mandiri.mandiriapps.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class EwalletModel(
    val name: String,
    val image: Int ,
    val balance: Double,
    val isConnected: Boolean

) : Parcelable