package com.mandiri.mandiriapps.presentation.learn

import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
import java.lang.reflect.Constructor

class Test: OnClickListener {
    public lateinit var buttonClick: Button
    public lateinit var textDetail: TextView
    public lateinit var activity: MainActivity


    override fun onClick(v: View?) {
        buttonClick.text = "Saya telah dipencet"
        textDetail.text = "aaaaa"
        activity.finish()

    }
}