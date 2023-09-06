package com.example.tasks

import android.content.Intent
import android.net.Uri
import android.provider.Settings
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver


@Composable
fun NotificationPermissionScreen() {
    val lifecycleOwner = LocalLifecycleOwner.current

    var showDialog by remember {
        mutableStateOf(false)
    }

    DisposableEffect(key1 = lifecycleOwner, effect = {
        val observer = LifecycleEventObserver { owner, event ->
            when (event) {
                Lifecycle.Event.ON_RESUME -> {
                    showDialog = false
                }

                else -> {
                }
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    })
    Box(modifier = Modifier.fillMaxSize()) {
        Button(onClick = {
            showDialog = true
        }) {
            Text(text = "Show Dialog")
        }
    }

    if (showDialog) {
        CustomDialog {
            showDialog = false
        }
    }

}

@Composable
fun CustomDialog(
    onDismissRequest: () -> Unit,
) {
    val context = LocalContext.current

    Dialog(onDismissRequest = {
        onDismissRequest.invoke()
    }) {
        Surface(
            modifier = Modifier.padding(8.dp), shape = RoundedCornerShape(16.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Enable Notification Permission First")
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = {

                    // Open App info
                    val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                    val uri = Uri.fromParts("package", context.packageName, null)
                    intent.data = uri
                    context.startActivity(intent)

                }) {
                    Text(text = "Go To Settings")
                }
            }
        }
    }
}