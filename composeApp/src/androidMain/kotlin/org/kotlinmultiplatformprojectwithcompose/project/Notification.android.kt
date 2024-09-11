package org.kotlinmultiplatformprojectwithcompose.project

import android.Manifest
import android.app.Activity
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

actual class Notification(private val context: Context) {
    @RequiresApi(Build.VERSION_CODES.O)
    actual fun showNotification() {
        //Creating builder for notification
        val notification = NotificationCompat.Builder(context, "try_notification")
            .setSmallIcon(R.drawable.baseline_notifications_24)
            .setContentTitle("Try Notification")
            .setContentText("This is the try notification")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .build()

        //Showing notification
        with(NotificationManagerCompat.from(context)) {
            if (ActivityCompat.checkSelfPermission(
                    context,
                    Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                val permissionRequestCode = 123 // arbitrary request code
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    ActivityCompat.requestPermissions(
                        context as Activity,
                        arrayOf(Manifest.permission.POST_NOTIFICATIONS),
                        permissionRequestCode
                    )
                }
            }
            notify(NotificationManagerCompat.IMPORTANCE_DEFAULT, notification)

        }

    }
}