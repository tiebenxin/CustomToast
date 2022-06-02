package com.visteon.txzing.toastdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.visteon.txzing.lib.CustomToast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.tv_click).setOnClickListener {
            CustomToast.show(this,"支付成功")
        }
    }
}