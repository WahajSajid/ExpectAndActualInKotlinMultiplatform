package org.kotlinmultiplatformprojectwithcompose.project

import androidx.compose.ui.uikit.ComposeUIViewControllerDelegate


@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class BatterManagerClass {
    actual fun getBatteryLevel():Int {
        return 5
    }
}