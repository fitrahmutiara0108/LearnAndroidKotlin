package com.mandiri.mandiriapps.presentation

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mandiri.mandiriapps.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener{
            handleRegister()
        }
    }

    private fun handleRegister(){

//        val nameValue = binding.etName.text.toString()
//        val ageValue = binding.etAge.text.toString().toInt()
//        val addressValue = binding.etAddress.text.toString()
//        val genderValue = binding.etGender.text.toString()

        with (binding){
            val nameValue = etName.text.toString()
            val ageValue = etAge.text.toString()
            val addressValue = etAddress.text.toString()
            val genderValue = etGender.text.toString()

            if(nameValue.isEmpty() || ageValue.isEmpty() || addressValue.isEmpty() || genderValue.isEmpty()){
                Toast.makeText(applicationContext, "Data tidak boleh kosong", Toast.LENGTH_SHORT).show()
            }
            else {
//                handleNavigateToProfile()
                val intent = Intent(this@RegisterActivity, ProfileActivity::class.java)
                intent.putExtra(KEY_NAME_VALUE, nameValue)
                intent.putExtra(KEY_AGE_VALUE, ageValue)
                intent.putExtra(KEY_ADDRESS_VALUE, addressValue)
                intent.putExtra(KEY_GENDER_VALUE, genderValue)
                startActivity(intent)
            }


        }


    }

    companion object {
        const val KEY_NAME_VALUE = "key_name_value"
        const val KEY_AGE_VALUE = "key_age_value"
        const val KEY_ADDRESS_VALUE = "key_address_value"
        const val KEY_GENDER_VALUE = "key_gender_value"
    }

}