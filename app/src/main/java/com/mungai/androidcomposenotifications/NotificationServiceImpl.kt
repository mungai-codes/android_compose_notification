package com.mungai.androidcomposenotifications

import android.app.Notification
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationCompat.BigTextStyle
import javax.inject.Inject

class NotificationServiceImpl @Inject constructor(
    private val builder: NotificationCompat.Builder
) : NotificationService {

    override fun createNotification(): Notification {
        return builder
            .setSmallIcon(R.drawable.baby_changing_station)
            .setContentTitle("Scheduled Notification")
            .setContentText("Make sure you have set up Dagger Hilt correctly in your project")
            .build()
    }
}