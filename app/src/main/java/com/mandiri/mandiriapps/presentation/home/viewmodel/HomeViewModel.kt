package com.mandiri.mandiriapps.presentation.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mandiri.mandiriapps.R
import com.mandiri.mandiriapps.model.EwalletModel
import com.mandiri.mandiriapps.model.SavingModel
import com.mandiri.mandiriapps.model.ServiceModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(): ViewModel() {
    private val _homeEWalletData = MutableLiveData<MutableList<EwalletModel>>()
    private val _homeSavingData = MutableLiveData<MutableList<SavingModel>>()
    private val _homeServiceData = MutableLiveData<MutableList<ServiceModel>>()

    val homeEWalletData: LiveData<MutableList<EwalletModel>> = _homeEWalletData
    val homeSavingData: LiveData<MutableList<SavingModel>> = _homeSavingData
    val homeServiceData: LiveData<MutableList<ServiceModel>> = _homeServiceData

    fun setData(){
        _homeServiceData.postValue(createDummyServiceList())
        _homeSavingData.postValue(populateSavingData())
        _homeEWalletData.postValue(createDummyEwalletList())
    }
    private fun createDummyEwalletList(): MutableList<EwalletModel> {
        return mutableListOf(
            EwalletModel(
                name = "Gojek",
                image = R.drawable.ic_shopee,
                balance = 400000.00,
                isConnected = false
            ),
            EwalletModel(
                name = "Shopee",
                image = R.drawable.ic_shopee,
                balance = 100000.00,
                isConnected = false
            ),
            EwalletModel(
                name = "Dana",
                image = R.drawable.ic_shopee,
                balance = 200000.00,
                isConnected = false
            ),
            EwalletModel(
                name = "LinkAja",
                image = R.drawable.ic_shopee,
                balance = 300000.00,
                isConnected = false
            )
        )
    }
    private fun populateSavingData(): MutableList<SavingModel> {
        return mutableListOf(
            SavingModel(
                savingName = "Tabungan NOW IDR",
                accountNumber = "1234567899876543",
                imageCard = R.drawable.ic_cropped_card
            ),
            SavingModel(
                savingName = "Mandiri Tabungan Rencana",
                accountNumber = "1234567899876543",
                imageCard = R.drawable.ic_cropped_card
            ),
            SavingModel(
                savingName = "Tabungan Reguler",
                accountNumber = "1234567899876543",
                imageCard = R.drawable.ic_cropped_card
            )
        )
    }
    private fun createDummyServiceList(): MutableList<ServiceModel> {
        return mutableListOf(
            ServiceModel(R.drawable.ic_livinmandiri, "Transfer\nRupiah"),
            ServiceModel(R.drawable.ic_livinmandiri, "Bayar"),
            ServiceModel(R.drawable.ic_livinmandiri, "Top-up"),
            ServiceModel(R.drawable.ic_livinmandiri, "e-money"),
            ServiceModel(R.drawable.ic_livinmandiri, "Sukha"),
            ServiceModel(R.drawable.ic_livinmandiri, "Transfer\nValas"),
            ServiceModel(R.drawable.ic_livinmandiri, "QR Terima\nTransfer"),
            ServiceModel(R.drawable.ic_livinmandiri, "QR Bayar"),
            ServiceModel(R.drawable.ic_livinmandiri, "Tap to Pay"),
            ServiceModel(R.drawable.ic_livinmandiri, "Investasi"),
            ServiceModel(R.drawable.ic_livinmandiri, "Layanan Cabang"),
            ServiceModel(R.drawable.ic_livinmandiri, "Setor Tarik"),
        )
    }
}