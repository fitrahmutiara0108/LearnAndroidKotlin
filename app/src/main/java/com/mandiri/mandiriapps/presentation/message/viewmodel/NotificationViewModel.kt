package com.mandiri.mandiriapps.presentation.message.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mandiri.mandiriapps.model.NotificationModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

//fungsi view model untuk single responsibility
@HiltViewModel
class NotificationViewModel @Inject constructor() : ViewModel() {
    //kegunaan live data biasanya ketika hp di rotate datanya ga ilang, tetep aman
    //kalo ga pake itu ada kemungkinan ketika dirotate data hilang
    private val _notificationData = MutableLiveData<List<NotificationModel>>()
    val notificationData: LiveData<List<NotificationModel>> = _notificationData

    fun setData() {
        _notificationData.postValue(populateDataNotification())
    }

    private fun populateDataNotification(): List<NotificationModel> {
        return listOf(
            NotificationModel(
                date = "11 Januari 2024",
                title = "Anda mendapat saldo masuk",
                description = "Saldo masuk sebesar Rp2.000.000.000,00"
            ),
            NotificationModel(
                date = "12 Januari 2024",
                title = "Anda mendapat saldo masuk",
                description = "Saldo masuk sebesar Rp5.000.000,00"
            )
        )
    }
}