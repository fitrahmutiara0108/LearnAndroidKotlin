package com.mandiri.mandiriapps.presentation

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mandiri.mandiriapps.R
import com.mandiri.mandiriapps.databinding.HomeMainActivityBinding
import com.mandiri.mandiriapps.helper.SharedPrefHelper
import com.mandiri.mandiriapps.presentation.home.HomeFragment
import com.mandiri.mandiriapps.presentation.message.MessageFragment
import com.mandiri.mandiriapps.utils.ConfirmationDialogUtil
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeMainActivity : AppCompatActivity() {
    private lateinit var binding: HomeMainActivityBinding

    @Inject
    lateinit var sharedPrefHelper: SharedPrefHelper
    private lateinit var dialogConfirmation: ConfirmationDialogUtil

    private val onNavigationSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigationHome -> {
                    replaceFragment(HomeFragment())
                    return@OnNavigationItemSelectedListener true
                }

                R.id.navigationPromo -> {
                    replaceFragment(ProfileFragment())
                    return@OnNavigationItemSelectedListener true
                }

                R.id.navigationMessage -> {
                    replaceFragment(MessageFragment())
                    return@OnNavigationItemSelectedListener true
                }

                R.id.navigationSetting -> {
                    replaceFragment(SettingFragment())
                    return@OnNavigationItemSelectedListener true
                }

                R.id.navigationLogout -> {
//                    logout()
//                    showDialog()
                    showConfirmation()
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HomeMainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        sharedPrefHelper = SharedPrefHelper(this)
        dialogConfirmation = ConfirmationDialogUtil(this)

        binding.bottomNavigation.setOnNavigationItemSelectedListener(onNavigationSelectedListener)

        if (savedInstanceState == null) {
            binding.bottomNavigation.selectedItemId = R.id.navigationHome
        }
    }

    private fun logout() {
        sharedPrefHelper.clearDataPref()
        startActivity(Intent(this, LoginActivity::class.java))
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }

    private fun showDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Log Out")
        builder.setMessage("Apakah anda yakin ingin log out?")
        builder.setPositiveButton("Ya") { _: DialogInterface, _: Int ->
            logout()
        }
        builder.setNegativeButton("Tidak") { _: DialogInterface, _: Int ->
        }

        val dialog = builder.create()
        dialog.show()
    }

    private fun showConfirmation() {
        val icon = R.drawable.ic_home

        dialogConfirmation.showConfirmationDialog(
            title = "Log Out",
            isOnHistoryTransaction = false,
            icon = icon,
            onConfirm = {
                logout()
            }, onCancel = {})

    }

}