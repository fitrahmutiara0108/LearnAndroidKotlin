package com.mandiri.mandiriapps.presentation.login.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mandiri.mandiriapps.helper.SharedPrefHelper
import com.mandiri.mandiriapps.model.NotificationModel
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val sharedPrefHelper: SharedPrefHelper) : ViewModel() {

    private val _loginSuccess = MutableLiveData<Boolean>()
    val loginSuccess = _loginSuccess

    fun login(password: String) {
        val correctPassword = "admin1234"

        if (password == correctPassword) {
            val dummyToken: String = UUID.randomUUID().toString()
            sharedPrefHelper.saveToken(dummyToken)
            _loginSuccess.value = true
        } else {
            _loginSuccess.value = false
        }
    }

    fun isTokenAvailable(): Boolean {
        val token = sharedPrefHelper.getToken()
        return token.isNotEmpty()
    }
}
