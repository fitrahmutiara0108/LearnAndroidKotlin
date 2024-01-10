package com.mandiri.mandiriapps.presentation.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import com.mandiri.mandiriapps.databinding.ActivityLoginBinding
import com.mandiri.mandiriapps.helper.SharedPrefHelper
import com.mandiri.mandiriapps.presentation.HomeMainActivity
import com.mandiri.mandiriapps.presentation.RegisterActivity
import com.mandiri.mandiriapps.presentation.home.HomeActivity
import com.mandiri.mandiriapps.presentation.login.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.UUID
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    @Inject
    lateinit var sharedPrefHelper: SharedPrefHelper
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        checkTokenAvailability()
        handleLogin()
        observeLoginSuccess()
    }

    private fun handleVisibility(view: View, isVisible: Boolean) {
        view.isVisible = isVisible
    }

    private fun handleNavigation() {
        val intent = Intent(this, HomeMainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun observeLoginSuccess() {
        viewModel.loginSuccess.observe(this, { success ->
            if (success) {
                Toast.makeText(applicationContext, "Berhasil", Toast.LENGTH_SHORT).show()
                handleVisibility(binding.tvErrorPassword, false)
                handleNavigation()
            } else {
                Toast.makeText(this@LoginActivity, "Gagal", Toast.LENGTH_SHORT).show()
                handleVisibility(binding.tvErrorPassword, true)
            }
        })
    }

    private fun handleLogin() {
        binding.apply {
            btnSubmit.setOnClickListener {
                val enteredPassword = etInputPassword.text.toString()
                viewModel.login(enteredPassword)
            }

            btnRegister.setOnClickListener {
                handleTo(RegisterActivity::class.java)
            }
        }
    }

    private fun checkTokenAvailability() {
        if (viewModel.isTokenAvailable()) {
            handleNavigation()
        }
    }

    private fun handleTo(clazz: Class<*>) {
        val intent = Intent(this, clazz)
        startActivity(intent)
    }

}
