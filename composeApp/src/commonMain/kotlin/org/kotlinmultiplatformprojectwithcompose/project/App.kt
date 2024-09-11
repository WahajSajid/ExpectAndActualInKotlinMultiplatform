package org.kotlinmultiplatformprojectwithcompose.project

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(batterManagerClass: BatterManagerClass, notification: Notification) {
    MaterialTheme {
        Box(
            Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            var buttonClicked by remember { mutableStateOf(false) }
            Column(modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "Click here to send the notification!")
                Button(onClick = {buttonClicked = true}, content = { Text("Send Notification") })
                if(buttonClicked){
                    notification.showNotification()
                    buttonClicked = false
                }
            }
        }
    }
}