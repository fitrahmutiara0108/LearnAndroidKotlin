package com.mandiri.mandiriapps

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mandiri.mandiriapps.databinding.ActivityHomeBinding
import com.mandiri.mandiriapps.databinding.ActivityMainBinding
import com.mandiri.mandiriapps.databinding.ActivityProfileBinding

class HomeActivity : AppCompatActivity(){
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}