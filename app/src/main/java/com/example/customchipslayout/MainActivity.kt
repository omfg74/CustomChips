package com.example.customchipslayout

import android.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    init {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val chips = CHipsLayout(this)
        val lp = FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT)
        val tv = TextView(this)
        val tv2 = TextView(this)
        val tv3 = TextView(this)
        val tv4 = TextView(this)
        val tv5 = TextView(this)
        tv.text=  "TETS ST ST STS TS"
        tv2.text=  "TETS ST ST STS TS"
        tv3.text=  "ololololo"
        tv4.text=  "ololololo"
        tv5.text=  "olвфывыфвфolololo"
//        lp.gravity = Gravity.CENTER
        chipsLayout.setMargins(12,10,12,10)
        chipsLayout.setPaddings(12,10,12,10)
        chipsLayout.setViewSize(null,36)
        chipsLayout.addView(tv,lp)
        chipsLayout.addView(tv2,lp)
        chipsLayout.addView(tv3,lp)
        chipsLayout.addView(tv4,lp)
        chipsLayout.addView(tv5,lp)
    }
}
