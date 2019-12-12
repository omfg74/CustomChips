package com.example.customchipslayout

import android.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        tv.text=  "TETS ST ST STS TS"
        tv2.text=  "TETS ST ST STS TS"
        tv3.text=  "ololololo"
        chipsLayout.setMargins(12,10,12,10)
        chipsLayout.addView(tv,lp)
        chipsLayout.addView(tv2,lp)
        chipsLayout.addView(tv3,lp)
    }
}
