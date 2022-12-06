package com.example.birthdayapplicationwithforegroundservice

import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputBinding
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import com.example.birthdayapplicationwithforegroundservice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)


        setContentView(binding.root)

        val userName : EditText = binding.etName




        binding.btnStart.setOnClickListener {

            if (userName.text.isEmpty()){
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_LONG).show()

            }else{

                Log.i("UserName", userName.text.toString())



//                val intent3 = Intent(this, BirthdayMessageService::class.java)
//                intent3.putExtra(Constants.USER_NAME, userName.text.toString())


                if (!isMyServiceRunning(MyService::class.java)){

                    Toast.makeText(
                        this,
                        "Service Started",
                        Toast.LENGTH_SHORT
                    ).show()

                    val startServiceIntent =Intent(this, MyService::class.java).apply {
                        putExtra(Constants.USER_NAME, userName.text.toString())
                    }
                    startService(startServiceIntent)


                }else{
                    Toast.makeText(
                        this,
                        "Service is already running",
                        Toast.LENGTH_SHORT
                    ).show()

                }
            }

        }

        binding.btnStop.setOnClickListener{
            if (isMyServiceRunning(MyService::class.java)) {
                Toast.makeText(
                    this,
                    "Service Stopped",
                    Toast.LENGTH_SHORT
                ).show()
                stopService(Intent(this, MyService::class.java))
            }else{
                Toast.makeText(
                    this,
                    "Service has already stopped",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }
    }

    private fun startStopService() {
        if (isMyServiceRunning(MyService::class.java)) {
            Toast.makeText(
                this,
                "Service Stopped",
                Toast.LENGTH_SHORT
            ).show()

            stopService(Intent(this, MyService::class.java))

        } else {
            Toast.makeText(
                this,
                "Service Started",
                Toast.LENGTH_SHORT
            ).show()

            startService(Intent(this, MyService::class.java))
        }
    }

    private fun isMyServiceRunning(mClass: Class<MyService>): Boolean {

        val manager:ActivityManager = getSystemService(
            Context.ACTIVITY_SERVICE
        ) as ActivityManager


        for(service: ActivityManager.RunningServiceInfo in
        manager.getRunningServices(Integer.MAX_VALUE)){

            if (mClass.name.equals(service.service.className)){
                return true
            }
        }
        return false
    }

}