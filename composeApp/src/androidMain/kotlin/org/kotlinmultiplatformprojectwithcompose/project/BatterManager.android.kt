package org.kotlinmultiplatformprojectwithcompose.project

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import kotlin.math.roundToInt

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class BatterManagerClass(private val context:Context) {
    actual fun getBatteryLevel():Int {
        val intentFilter = IntentFilter(Intent.ACTION_BATTERY_CHANGED)
        val batteryStatus = context.registerReceiver(null,intentFilter)
        val level = batteryStatus?.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)?:-1
        val scale  = batteryStatus?.getIntExtra(BatteryManager.EXTRA_SCALE, -1)?:-1
        return (level/scale.toFloat()*100).roundToInt()
    }
}