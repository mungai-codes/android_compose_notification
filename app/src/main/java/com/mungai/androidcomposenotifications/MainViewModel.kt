package com.mungai.androidcomposenotifications

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val service: NotificationService
) : ViewModel() {

    fun showNotification() {
        service.showNotification()
    }

    fun cancelNotification() {
        service.cancelNotification()
    }

    fun updateNotification() {
        service.updateNotification()
    }
}