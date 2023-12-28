package com.mandiri.mandiriapps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import com.mandiri.mandiriapps.databinding.ActivityMainBinding
import com.mandiri.mandiriapps.databinding.ActivityProfileBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        handleLogin()
    }

//        button.setOnClickListener {
////            Toast.makeText(applicationContext, resultInput.toString(), Toast.LENGTH_SHORT).show()
//            if(etInput1.text.isNotEmpty() && etInput2.text.isNotEmpty()){
//                val resultInput = etInput1.text.toString().toInt()*etInput2.text.toString().toInt()
//                tvResult.text = resultInput.toString()
//            }
//            else{
//                Toast.makeText(applicationContext, "Inputan tidak boleh kosong", Toast.LENGTH_SHORT).show()
//            }

        private fun handleVisibility(view: View, isVisible: Boolean){
            view.isVisible = isVisible
        }

        private fun handleNavigateToHome(){
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }

        private fun handleNavigateToRegister(){
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }

        private fun handleLogin(){
//            val etInputPass = findViewById<EditText>(R.id.etInputPassword)
            val password = "admin1234"
//            val tvErrorPassword = findViewById<TextView>(R.id.tvErrorPassword)
//            val buttonLogin = findViewById<Button>(R.id.btnSubmit)
//            val buttonRegister = findViewById<Button>(R.id.btnRegister)

            binding.apply{
                btnSubmit.setOnClickListener {
                    if(etInputPassword.text.toString() == password){
//                    Log.d("aaaa", etInputPass.text.toString())
                        Toast.makeText(applicationContext, "Berhasil", Toast.LENGTH_SHORT).show()
                        handleVisibility(tvErrorPassword, false)
                        handleNavigateToHome()
//                    tvErrorPassword.visibility = View.VISIBLE
                    }
                    else{
                        Toast.makeText(this@MainActivity, "Gagal", Toast.LENGTH_SHORT).show()
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

    private fun handleTo(clazz: Class<*>){
        val intent = Intent(this, clazz)
        startActivity(intent)
    }
}