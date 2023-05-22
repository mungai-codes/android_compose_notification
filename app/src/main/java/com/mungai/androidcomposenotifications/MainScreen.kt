package com.mungai.androidcomposenotifications

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mungai.androidcomposenotifications.ui.theme.AndroidComposeNotificationsTheme

@Composable
fun MainScreen(
    viewModel: MainViewModel = hiltViewModel(),
    hasPermission: Boolean,
    requestPermission: () -> Unit
) {
    MainScreenContent(
        hasPermission = hasPermission,
        showNotification = viewModel::showNotification,
        updateNotification = viewModel::updateNotification,
        cancelNotification = viewModel::cancelNotification,
        requestPermission = requestPermission
    )
}

@Composable
fun MainScreenContent(
    hasPermission: Boolean,
    showNotification: () -> Unit,
    updateNotification: () -> Unit,
    cancelNotification: () -> Unit,
    requestPermission: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AnimatedVisibility(
            visible = !hasPermission,
            enter = fadeIn(animationSpec = tween(500)),
            exit = fadeOut(animationSpec = tween(1000))
        ) {
            Button(
                onClick = requestPermission
            ) {
                Text(text = "Request permission")
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        AnimatedVisibility(
            visible = hasPermission,
            enter = fadeIn(animationSpec = tween(500)),
            exit = fadeOut(animationSpec = tween(500))
        ) {
            Column {
                Button(onClick = showNotification) {
                    Text(text = "Show notification")
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = updateNotification) {
                    Text(text = "Update notification")
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = cancelNotification) {
                    Text(text = "Cancel notification")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    AndroidComposeNotificationsTheme(darkTheme = true) {
        MainScreenContent(
            hasPermission = false,
            showNotification = { /*TODO*/ },
            updateNotification = {/*TODO*/ },
            cancelNotification = {/*TODO*/ },
            requestPermission = {/*TODO*/ }
        )
    }
}