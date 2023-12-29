package com.mandiri.mandiriapps

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mandiri.mandiriapps.adapter.EwalletAdapter
import com.mandiri.mandiriapps.databinding.ActivityHomeBinding
import com.mandiri.mandiriapps.databinding.ActivityMainBinding
import com.mandiri.mandiriapps.databinding.ActivityProfileBinding
import com.mandiri.mandiriapps.model.EwalletModel

class HomeActivity : AppCompatActivity(){
    private lateinit var binding: ActivityHomeBinding
    private var ewalletAdapter = EwalletAdapter()
    private var dummyEwalletList: List<EwalletModel>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.vComponentHome.rvEwallet.adapter = ewalletAdapter
        ewalletAdapter.setDataEwallet(createDummyEwalletList())
//        ewalletAdapter.setOnClickEwallet { Ewallet -> {
//            val newData : List<Boolean> = ewalletAdapter.listEwallet.map{
//
//            }
//        } }

    }

    private fun createDummyEwalletList(): MutableList<EwalletModel> {
        return mutableListOf(
            EwalletModel(name = "Gojek", image = R.drawable.ic_shopee, balance = 400000.00, isConnected = false),
            EwalletModel(name = "Shopee", image = R.drawable.ic_shopee, balance = 100000.00, isConnected = true),
            EwalletModel(name = "Dana", image = R.drawable.ic_shopee, balance = 200000.00, isConnected = false),
            EwalletModel(name = "LinkAja", image = R.drawable.ic_shopee, balance = 300000.00, isConnected = true)
        )
    }
}