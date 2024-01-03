package com.mandiri.mandiriapps.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mandiri.mandiriapps.presentation.RegisterActivity.Companion.KEY_ADDRESS_VALUE
import com.mandiri.mandiriapps.presentation.RegisterActivity.Companion.KEY_AGE_VALUE
import com.mandiri.mandiriapps.presentation.RegisterActivity.Companion.KEY_GENDER_VALUE
import com.mandiri.mandiriapps.presentation.RegisterActivity.Companion.KEY_NAME_VALUE
import com.mandiri.mandiriapps.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra(KEY_NAME_VALUE)
        val age = intent.getStringExtra(KEY_AGE_VALUE)
        val address = intent.getStringExtra(KEY_ADDRESS_VALUE)
        val gender = intent.getStringExtra(KEY_GENDER_VALUE)

        binding.tvName.text = name
        binding.tvAge.text = age
        binding.tvAddress.text = address
        binding.tvGender.text = gender
    }

}