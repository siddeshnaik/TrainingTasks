package com.example.birthdayapplicationwithforegroundservice

import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import android.os.IBinder
import android.util.Log
import android.widget.RemoteViews
import androidx.annotation.RequiresApi
import com.example.birthdayapplicationwithforegroundservice.Constants.CHANNEL_ID

import com.example.birthdayapplicationwithforegroundservice.Constants.NOTIFICATION_ID

class MyService: Service() {

    private var userNameRecieved :String = ""

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()


        createNotificationChannel()
    }


    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            val serviceChannel = NotificationChannel(
                Constants.CHANNEL_ID, "My Service Channel",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val manager = getSystemService(
                NotificationManager::class.java
            )

            manager.createNotificationChannel(serviceChannel)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        userNameRecieved = intent?.getStringExtra(Constants.USER_NAME)?: ""
        showNotification()
        return START_STICKY
    }

    @SuppressLint("SuspiciousIndentation")
    @RequiresApi(Build.VERSION_CODES.O)
    private fun showNotification() {


        val notificationIntent = Intent(this, BirthdayMessageService::class.java)
            notificationIntent.putExtra(Constants.USER_NAME, userNameRecieved)

        val pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT)

        val contentView = RemoteViews(packageName, R.layout.activity_after_notification)

        val notification = Notification
            .Builder(this, Constants.CHANNEL_ID)
            .setContent(contentView)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setLargeIcon(
                BitmapFactory.decodeResource(
                    this.resources,
                    R.drawable.ic_launcher_background
                )
            )
            .setContentIntent(pendingIntent)
            .build()

        startForeground(Constants.NOTIFICATION_ID, notification)

    }
}