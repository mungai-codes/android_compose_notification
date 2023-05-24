package com.mungai.androidcomposenotifications

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NotificationModule {

    @Provides
    @Singleton
    fun providesNotificationBuilder(
        @ApplicationContext context: Context
    ): NotificationCompat.Builder {
        return NotificationCompat.Builder(context, "Main Channel Id")
            .setPriority(NotificationManager.IMPORTANCE_DEFAULT)
    }

    @Provides
    @Singleton
    fun providesNotificationManager(
        @ApplicationContext context: Context
    ): NotificationManager {
        val channel = NotificationChannel(
            "Main Channel Id",
            "Main Channel",
            NotificationManager.IMPORTANCE_DEFAULT
        ).apply {
            description = "Counter Notification Increment"
        }
        val manager: NotificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.createNotificationChannel(channel)
        return manager
    }

    @Provides
    @Singleton
    fun providesNotificationService(
        builder: NotificationCompat.Builder
    ): NotificationService {
        return NotificationServiceImpl(builder = builder)
    }
}