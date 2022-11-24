package com.example.broadcastapp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var senderButton: Button? = null
    private var userText: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        senderButton = findViewById(R.id.buttonSender)
        userText = findViewById<EditText>(R.id.editTextBox)
        val userProvidedData = userText?.text



        senderButton?.setOnClickListener{


            Toast.makeText(this, "Sent Data: $userProvidedData", Toast.LENGTH_SHORT).show()

            val intent = Intent("com.example.broadcastapp1.ACTION_SEND")
            intent.putExtra("com.example.broadcastapp1.EXTRA_DATA", userProvidedData.toString())
            sendBroadcast(intent)


    }





    }
}

