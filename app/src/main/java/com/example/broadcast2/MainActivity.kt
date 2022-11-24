package com.example.broadcast2

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    var ReceivedData:String? =null
    var txtView : TextView? = null


    val broad = object :BroadcastReceiver(){


        override fun onReceive(context: Context?, intent: Intent?) {
            when(intent?.action){
                "com.example.broadcastapp1.ACTION_SEND" -> {
                    ReceivedData = intent?.getStringExtra("com.example.broadcastapp1.EXTRA_DATA")
                    Toast.makeText(context, "Received Data: ${ReceivedData}",Toast.LENGTH_SHORT).show()

                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intentFilter = IntentFilter("com.example.broadcastapp1.ACTION_SEND")
        registerReceiver(broad, intentFilter)

        txtView = findViewById(R.id.txtView1)



    }

    override fun onResume() {
        super.onResume()
        txtView?.text = ReceivedData
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(broad)
    }
}