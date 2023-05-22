package com.mungai.androidcomposenotifications

import android.app.NotificationManager
import androidx.core.app.NotificationCompat
import javax.inject.Inject

class NotificationServiceImpl @Inject constructor(
    private val manager: NotificationManager,
    private val builder: NotificationCompat.Builder
) : NotificationService {

    override fun showNotification() {
        manager.notify(
            1, builder
                .setSmallIcon(R.drawable.baby_changing_station)
                .setContentTitle("EUREKA")
                .setContentText("Eureka it works!!!. @mungai_codes")
                .build()
        )
    }

    override fun cancelNotification() {
        manager.cancel(1)
    }

    override fun updateNotification() {
        manager.notify(
            1, builder
                .setSmallIcon(R.drawable.old_man)
                .setContentTitle("Updated version")
                .setContentText("This is an updated notification.")
                .build()
        )
    }
}