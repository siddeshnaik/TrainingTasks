package com.example.birthdaygiftservicetask

import android.annotation.SuppressLint
import android.app.Notification
import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi

class BirthdayMessageService : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    @RequiresApi(Build.VERSION_CODES.O)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_birthday_message_service)

        val textView2:TextView = findViewById(R.id.textView2)

        val imageView1:ImageView = findViewById(R.id.imageView1)

        val userName =intent.getStringExtra("UserName")
        textView2.text = userName + "!!!!"

        if(userName=="Anukeerti"){
            imageView1.setImageResource(R.drawable.birthday_cake)
        }



    }
}