package com.mungai.androidcomposenotifications

import android.app.Notification

interface NotificationService {
    fun createNotification() : Notification

}