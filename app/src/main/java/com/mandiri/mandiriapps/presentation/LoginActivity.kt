package com.mandiri.mandiriapps.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import com.mandiri.mandiriapps.databinding.ActivityLoginBinding
import com.mandiri.mandiriapps.helper.SharedPref
import com.mandiri.mandiriapps.presentation.home.HomeActivity
import com.mandiri.mandiriapps.presentation.message.MessageFragment
import java.util.UUID


class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var sharedPref: SharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPref = SharedPref(context = this@LoginActivity)
        checkTokenAvailability()
        handleLogin()
    }

    private fun handleVisibility(view: View, isVisible: Boolean) {
        view.isVisible = isVisible
    }

    private fun handleNavigateToHome() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun handleNavigation() {
        val intent = Intent(this, HomeMainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun handleNavigateToRegister() {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun handleLogin() {
        val password = "admin1234"

        binding.apply {
            btnSubmit.setOnClickListener {
                if (etInputPassword.text.toString() == password) {
                    Toast.makeText(applicationContext, "Berhasil", Toast.LENGTH_SHORT).show()
                    handleVisibility(tvErrorPassword, false)
                    handleNavigation()
                    val dummyToken:String = UUID.randomUUID().toString()
                    sharedPref.saveToken(dummyToken)
//                    tvErrorPassword.visibility = View.VISIBLE
                } else {
                    Toast.makeText(this@LoginActivity, "Gagal", Toast.LENGTH_SHORT).show()
//                    tvErrorPassword.visibility = View.VISIBLE
                    handleVisibility(tvErrorPassword, true)
                }
            }

            btnRegister.setOnClickListener {
//                    handleNavigateToRegister()
                handleTo(RegisterActivity::class.java)
            }
        }
    }

    private fun handleTo(clazz: Class<*>) {
        val intent = Intent(this, clazz)
        startActivity(intent)
    }

    private fun checkTokenAvailability(){
        val token = sharedPref.getToken()
        if (!token.isEmpty()){
            handleNavigation()
        }
    }
}