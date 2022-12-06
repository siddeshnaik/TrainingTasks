package com.example.birthdayapplicationwithforegroundservice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class BirthdayMessageService : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_birthday_message_service)


        val textView2: TextView = findViewById(R.id.textView2)

        val imageView1: ImageView = findViewById(R.id.imageView1)

        val userName =intent.getStringExtra(Constants.USER_NAME)
        textView2.text = userName + "!!!!"

    }
}