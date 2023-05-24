package com.mungai.androidcomposenotifications

import android.app.NotificationManager
import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.ForegroundInfo
import androidx.work.Worker
import androidx.work.WorkerParameters
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

@HiltWorker
class NotificationWorker @AssistedInject constructor(
    @Assisted appContext: Context,
    @Assisted workerParams: WorkerParameters,
    private val notificationService: NotificationService,
    private val notificationManager: NotificationManager
) : Worker(appContext, workerParams) {

    override fun doWork(): Result {
        Log.d("My Notification Worker", "Eureka!!")
        notificationManager.notify(1, notificationService.createNotification())
        return Result.success()
    }

    override fun getForegroundInfo(): ForegroundInfo {
        return ForegroundInfo(1, notificationService.createNotification())
    }
}