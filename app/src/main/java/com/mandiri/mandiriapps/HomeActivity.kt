package com.mandiri.mandiriapps

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mandiri.mandiriapps.adapter.EwalletAdapter
import com.mandiri.mandiriapps.adapter.SavingAdapter
import com.mandiri.mandiriapps.databinding.ActivityHomeBinding
import com.mandiri.mandiriapps.databinding.ActivityMainBinding
import com.mandiri.mandiriapps.databinding.ActivityProfileBinding
import com.mandiri.mandiriapps.model.EwalletModel
import com.mandiri.mandiriapps.model.SavingModel

class HomeActivity : AppCompatActivity(){
    private lateinit var binding: ActivityHomeBinding
    private var ewalletAdapter = EwalletAdapter()
    private var dummyEwalletList: MutableList<EwalletModel>? = null
//    private var dummySavingList: MutableList<SavingModel>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpViewEwallet()
    }

    private fun setUpViewEwallet(){
        dummyEwalletList = createDummyEwalletList()

        binding.vComponentHomeEwallet.rvEwallet.adapter = ewalletAdapter
        ewalletAdapter.setDataEwallet(dummyEwalletList ?: mutableListOf())
        ewalletAdapter.setOnClickEwallet { Ewallet ->
            Toast.makeText(this, "Berhasil menghubungkan ${Ewallet.name}", Toast.LENGTH_SHORT).show()

            dummyEwalletList?.forEach{
                if(it.name == Ewallet.name) it.isConnected = true
            }

            ewalletAdapter.setDataEwallet(dummyEwalletList?.toMutableList() ?: mutableListOf())
        }
    }

    private fun createDummyEwalletList(): MutableList<EwalletModel> {
        return mutableListOf(
            EwalletModel(name = "Gojek", image = R.drawable.ic_shopee, balance = 400000.00, isConnected = false),
            EwalletModel(name = "Shopee", image = R.drawable.ic_shopee, balance = 100000.00, isConnected = false),
            EwalletModel(name = "Dana", image = R.drawable.ic_shopee, balance = 200000.00, isConnected = false),
            EwalletModel(name = "LinkAja", image = R.drawable.ic_shopee, balance = 300000.00, isConnected = false)
        )
    }

    private fun setUpViewSaving(){
//        dummySavingList = populateSavingData()
        binding.vComponentHomeSaving.rvSaving.adapter = SavingAdapter(populateSavingData())
    }
    private fun populateSavingData() : MutableList<SavingModel> {
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
}