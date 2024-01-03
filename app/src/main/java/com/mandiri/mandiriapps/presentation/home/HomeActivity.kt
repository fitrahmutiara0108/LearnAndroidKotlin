package com.mandiri.mandiriapps.presentation.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mandiri.mandiriapps.adapter.EwalletAdapter
import com.mandiri.mandiriapps.databinding.ActivityHomeBinding
import com.mandiri.mandiriapps.model.EwalletModel

class HomeActivity : AppCompatActivity(){
    private lateinit var binding: ActivityHomeBinding
    //untuk save token

    private var dummyEwalletList: MutableList<EwalletModel>? = null
//    private var dummySavingList: MutableList<SavingModel>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}