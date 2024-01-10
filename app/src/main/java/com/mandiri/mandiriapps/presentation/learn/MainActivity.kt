package com.mandiri.mandiriapps.presentation.learn

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.mandiri.mandiriapps.R
import com.mandiri.mandiriapps.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {
    //    private lateinit var binding: ActivityMainBinding

    lateinit var buttonClick: Button
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        buttonClick = this.binding.btnClickMe


        this.setContentView(binding.root)


        buttonClick.text = "Submit"
        val sum = {number1: Int, number2: Int ->
            val total = number1 + number2
            total
        }

        sum.invoke(2,3)

        val test = Test()
        test.buttonClick = buttonClick
        test.textDetail = binding.tvTestText
        test.activity = this
        var mainAdapter = MainAdapter()
        mainAdapter.aContext = this

        mainAdapter.setData(mutableListOf("lorem","ipsum","lorem","ipsum","lorem","ipsum"))
        binding.rvTest.adapter = mainAdapter
//        val test = {view: View ->
//            buttonClick.text = "Saya telah dipencet"
//        }
        buttonClick.setOnClickListener(this)
    }

    fun sum(number1: Int, number2: Int): Int {
        val total = number1 + number2
        return total
    }

    override fun onClick(v: View?) {
        buttonClick.text = "Saya telah dipencet"
    }
}